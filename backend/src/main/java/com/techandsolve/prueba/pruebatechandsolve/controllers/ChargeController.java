/**
 * 
 */
package com.techandsolve.prueba.pruebatechandsolve.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.techandsolve.prueba.pruebatechandsolve.busines.services.ChargeService;
import com.techandsolve.prueba.pruebatechandsolve.busines.services.TraceService;
import com.techandsolve.prueba.pruebatechandsolve.models.Line;
import com.techandsolve.prueba.pruebatechandsolve.models.ResponseError;
import com.techandsolve.prueba.pruebatechandsolve.models.Travel;
import com.techandsolve.prueba.pruebatechandsolve.utils.ValidationUtil;


/**
 * @author DANTEDRD
 *
 */
@RestController
@RequestMapping("/api/charge")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ChargeController {
    private final ChargeService chargeService;
    private final TraceService traceService;
    private ValidationUtil validationUtil;
	
	public ChargeController(ChargeService ChargeService,ValidationUtil validationUtil,TraceService traceService) {
		  this.chargeService=ChargeService;
		  this.validationUtil=validationUtil;
		  this.traceService=traceService;
	}
	
	@PostMapping(value="/")
	public ResponseEntity<Object> generateTravels(@RequestParam("file") MultipartFile file,@RequestParam("identification") String identification) {
		List<Line> lines = this.chargeService.getLines(file);
		int days=this.chargeService.getDays(file);
		String err=this.validationUtil.validateLines(lines);
		boolean validateDays=this.validationUtil.validateDays(days);
		if(err!=""||!validateDays) {
			err=!validateDays?this.validationUtil.LIMIT_DAYS_EXCEEDED:err;
			ResponseError resonseData=new ResponseError();
			resonseData.setError(err);
			this.traceService.save(identification,err);
			return new ResponseEntity<>(resonseData, HttpStatus.NOT_ACCEPTABLE);
		}
		List<Travel> travels = this.chargeService.getTravels(lines);
		this.chargeService.save(identification, travels);
		this.traceService.save(identification, travels.toString());
		return new ResponseEntity<>(travels, HttpStatus.OK);
	}
	
	@GetMapping("downloadFile/{identification}")
	public InputStreamResource downLoadFile (@PathVariable("identification") String identification,HttpServletResponse response) throws IOException {
		response.setContentType("application/txt");
		response.setHeader("Content-Disposition", "attachment; filename=\"lazy_loading_output.txt\"");
		InputStreamResource resource = this.chargeService.getFile(identification);
		return resource;
	}
	
}
