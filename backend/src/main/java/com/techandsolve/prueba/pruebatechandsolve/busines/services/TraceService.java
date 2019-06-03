/**
 * 
 */
package com.techandsolve.prueba.pruebatechandsolve.busines.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.techandsolve.prueba.pruebatechandsolve.busines.repositories.TraceRepository;
import com.techandsolve.prueba.pruebatechandsolve.models.Trace;

/**
 * @author DANTEDRD
 *
 */
@Service
public class TraceService {
	private final TraceRepository traceRepository;
	
	public TraceService(TraceRepository traceRepository) {
		  this.traceRepository=traceRepository;
	}
	
	public void save(String identification,String log){
	   Trace trace=new Trace();
	   trace.setIdentification(identification);
	   trace.setDateExecution(new Date());
	   trace.setLog(log);
       this.traceRepository.save(trace);
	}
}
