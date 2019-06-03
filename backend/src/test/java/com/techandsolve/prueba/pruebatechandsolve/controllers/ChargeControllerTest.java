package com.techandsolve.prueba.pruebatechandsolve.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;
import com.techandsolve.prueba.pruebatechandsolve.busines.services.ChargeService;
import com.techandsolve.prueba.pruebatechandsolve.busines.services.TraceService;
import com.techandsolve.prueba.pruebatechandsolve.models.Line;
import com.techandsolve.prueba.pruebatechandsolve.utils.ValidationUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(ChargeController.class)
public class ChargeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ChargeService chargeService;
	
	@MockBean
	private TraceService traceService;

	@MockBean
	private ValidationUtil validationUtil;

	@SuppressWarnings("deprecation")
	@Test
	public void generateTravelsTest() throws Exception {

		MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain",
				"Spring Framework".getBytes());

		ArrayList<Line> lines = new ArrayList<Line>();
		int[] subline1 = new int[] { 30, 30, 1, 1 };
		lines.add(new Line(4, 1, subline1));

		int[] subline2 = new int[] { 20, 20, 20 };
		lines.add(new Line(3, 2, subline2));

		when(chargeService.getLines(any(MultipartFile.class))).thenReturn(lines);
		
		doNothing().when(traceService).save(any(String.class), any(String.class));
		doNothing().when(chargeService).save(any(String.class),any(List.class));
		
		when(validationUtil.validateDays(any(Integer.class))).thenReturn(true);

		when(validationUtil.validateLines((List<Line>) any(List.class))).thenReturn("");

		mockMvc.perform(fileUpload("/api/charge/").file(multipartFile).param("identification", "123213423545"))
				.andExpect(status().isOk());
	}

	@Test
	public void downloadFileTest() throws Exception {
		when(chargeService.getFile(any(String.class))).thenReturn(null);
		mockMvc.perform(get("/api/charge/downloadFile/2332442355365")).andExpect(status().isOk());
	}
}
