package com.techandsolve.prueba.pruebatechandsolve.busines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techandsolve.prueba.pruebatechandsolve.models.Trace;

public interface TraceRepository extends JpaRepository<Trace,Integer>{
	
}
