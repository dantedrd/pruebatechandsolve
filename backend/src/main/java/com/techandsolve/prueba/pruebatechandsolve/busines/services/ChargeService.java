package com.techandsolve.prueba.pruebatechandsolve.busines.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techandsolve.prueba.pruebatechandsolve.busines.repositories.ChargeRepository;
import com.techandsolve.prueba.pruebatechandsolve.models.Line;
import com.techandsolve.prueba.pruebatechandsolve.models.Travel;
import com.techandsolve.prueba.pruebatechandsolve.utils.CalculateTravelsUtil;

@Service
public class ChargeService {
	private final ChargeRepository chargeRepository;
	private final CalculateTravelsUtil calculateTravelsUtil;
	
	public ChargeService(ChargeRepository chargeRepository,CalculateTravelsUtil calculateTravelsUtil) {
		  this.chargeRepository=chargeRepository;
		  this.calculateTravelsUtil=calculateTravelsUtil;
	}
	
	public int getDays(MultipartFile file) {
		return this.chargeRepository.getDays(file);
	}
	
	public ArrayList<Line> getLines(MultipartFile file) {
		return this.chargeRepository.getLines(file);
	}
	
	public ArrayList<Travel> getTravels(List<Line> lines) {
		return this.calculateTravelsUtil.getTravels(lines);
	}
	
	public void save(String identification,List<Travel> travels) {
		 this.chargeRepository.saveFile(identification, travels);
	}
	
	public InputStreamResource getFile(String identification) {
		 return this.chargeRepository.getFile(identification);
	}
	
	
	
}
