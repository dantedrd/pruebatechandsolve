package com.techandsolve.prueba.pruebatechandsolve.busines.repositories;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techandsolve.prueba.pruebatechandsolve.models.Line;
import com.techandsolve.prueba.pruebatechandsolve.models.Travel;
import com.techandsolve.prueba.pruebatechandsolve.utils.ArrayUtil;

@Service
public class ChargeRepository {

	private List<Integer> readFile(MultipartFile file) {
		List<Integer> result = new ArrayList<>();
		try {
			String line;
			InputStream is = file.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				result.add(Integer.parseInt(line));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int getDays(MultipartFile file) {
		List<Integer> result = this.readFile(file);
		return result.get(0);
	}

	public ArrayList<Line> getLines(MultipartFile file) {
		List<Integer> result = this.readFile(file);
		ArrayList<Line> daysLine = new ArrayList<Line>();
		int day = 1;
		for (int i = 1; i < result.size(); i++) {
			int lines = result.get(i);
			ArrayList<Integer> sublines = new ArrayList<Integer>();
			for (int f = 0; f < lines; f++) {
				int item=(i + 1) + f;
				if(item<result.size()) {
					sublines.add(result.get(item));	
				}
			}
			int [] subLinesOrder = ArrayUtil.orderByBubbleSort(sublines);
			daysLine.add(new Line(lines, day, subLinesOrder));
			day += 1;
			i = i + lines;
		}
		return daysLine;
	}

	public void saveFile(String identification, List<Travel> travels) {
		try {
			String nombreArchivo = identification + ".txt";
			FileWriter fichero = new FileWriter(System.getProperty("user.home") + "/" + nombreArchivo);
			PrintWriter pw = new PrintWriter(fichero);
			for (int i = 0; i < travels.size(); i++) {
				pw.println("Case #" + travels.get(i).getCaseNumber() + ": " + travels.get(i).getTotalTravels());
			}
			fichero.close();
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public InputStreamResource getFile(String identification) {
		String nombreArchivo = identification + ".txt";
		InputStreamResource resource=null;
		try {
			resource = new InputStreamResource(
					new FileInputStream(System.getProperty("user.home") + "/" + nombreArchivo));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resource;
	}

}
