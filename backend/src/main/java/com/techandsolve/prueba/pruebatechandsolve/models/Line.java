/**
 * 
 */
package com.techandsolve.prueba.pruebatechandsolve.models;

/**
 * @author DANTEDRD
 *
 */
public class Line {
	private int linesIndicated;
	private int day;
	private int[] sublines;
	
	public Line() {
		
	}

	public Line(int linesIndicated,int day, int[] sublines) {
		this.linesIndicated=linesIndicated;
		this.day = day;
		this.sublines = sublines;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int[] getSublines() {
		return sublines;
	}

	public void setSublines(int[] sublines) {
		this.sublines = sublines;
	}

	public int getLinesIndicated() {
		return linesIndicated;
	}

	public void setLinesIndicated(int linesIndicated) {
		this.linesIndicated = linesIndicated;
	}
	
	

}
