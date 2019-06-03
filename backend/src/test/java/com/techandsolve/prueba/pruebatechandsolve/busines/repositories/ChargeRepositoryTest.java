package com.techandsolve.prueba.pruebatechandsolve.busines.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;

import com.techandsolve.prueba.pruebatechandsolve.models.Line;

@RunWith(MockitoJUnitRunner.class)
public class ChargeRepositoryTest {
	@InjectMocks
	private ChargeRepository chargeRepository;
	
	
	@Test
    public void testGetLines() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
                "text/plain", "5\n4\n30\n30\n1\n1\n3\n20\n20\n20".getBytes());
        
        List<Line> lines= chargeRepository.getLines(multipartFile);
        assertEquals(2, lines.size());
	}
	
}
