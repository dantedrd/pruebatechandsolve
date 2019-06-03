package com.techandsolve.prueba.pruebatechandsolve.busines.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import com.techandsolve.prueba.pruebatechandsolve.busines.repositories.ChargeRepository;
import com.techandsolve.prueba.pruebatechandsolve.models.Line;
import com.techandsolve.prueba.pruebatechandsolve.models.Travel;
import com.techandsolve.prueba.pruebatechandsolve.utils.CalculateTravelsUtil;

@RunWith(MockitoJUnitRunner.class)
public class ChargeServicesTest {
	@Mock
	private ChargeRepository chargeRepository;
	
	@Mock
	private CalculateTravelsUtil calculateTravelsUtil;

	@InjectMocks
	private ChargeService chargeService;

	@Test
	public void getLinesService() {
		
		MockMultipartFile multipartFile = new MockMultipartFile("file", "input.txt",
                "text/plain", "5\n4\n30\n30\n1\n1\n3\n20\n20\n20".getBytes());
		
		ArrayList<Line> lines=new ArrayList<Line>();
		int[] subline1=new int[] {30, 30,1, 1};
		lines.add(new Line(4,1,subline1));
		
		int[] subline2=new int[] {20, 20,20};
		lines.add(new Line(3,2,subline2));

		Mockito.when(chargeRepository.getLines(any(MultipartFile.class))).thenReturn(lines);

		
		ArrayList<Line> linesGenerate = chargeService.getLines(multipartFile);

		assertEquals(lines.size(), linesGenerate.size());
	}
	
	@Test
	public void getTravels() {
		
				
		ArrayList<Travel> travels=new ArrayList<Travel>();
		travels.add(new Travel(1,2));
		travels.add(new Travel(2,1));

		Mockito.when(calculateTravelsUtil.getTravels((List<Line>) any(List.class))).thenReturn(travels);
         
		ArrayList<Line> lines=new ArrayList<Line>();
		int[] subline1=new int[] {30, 30,1, 1};
		lines.add(new Line(4,1,subline1));
		
		int[] subline2=new int[] {20, 20,20};
		lines.add(new Line(3,2,subline2));
		
		ArrayList<Travel> travelsGenerate = chargeService.getTravels(lines);

		assertEquals(travels.size(), travelsGenerate.size());
	}

}
