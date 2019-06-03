package com.techandsolve.prueba.pruebatechandsolve.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.techandsolve.prueba.pruebatechandsolve.models.Line;
import com.techandsolve.prueba.pruebatechandsolve.models.Travel;


@RunWith(MockitoJUnitRunner.class)
public class CalculateTravelsUtilTest {
	@InjectMocks
	private CalculateTravelsUtil calculateTravelsUtil;
	
	@Test
	public void getLinesService() {
		ArrayList<Line> lines=new ArrayList<Line>();
		int[] subline1=new int[] {30, 30,1, 1};
		lines.add(new Line(4,1,subline1));
		
		int[] subline2=new int[] {20, 20,20};
		lines.add(new Line(3,2,subline2));
		
		ArrayList<Travel> travels=calculateTravelsUtil.getTravels(lines);
		
		assertEquals(lines.size(), travels.size());
		
	}
}
