package com.techandsolve.prueba.pruebatechandsolve.models;

public class Travel {
	int caseNumber;
	int totalTravels;

	public Travel() {

	}
	
	

	public Travel(int caseNumber, int totalTravels) {
		super();
		this.caseNumber = caseNumber;
		this.totalTravels = totalTravels;
	}



	public int getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(int caseNumber) {
		this.caseNumber = caseNumber;
	}

	public int getTotalTravels() {
		return totalTravels;
	}

	public void setTotalTravels(int totalTravels) {
		this.totalTravels = totalTravels;
	}



	@Override
	public String toString() {
		return "{caseNumber=" + caseNumber + ", totalTravels=" + totalTravels + "}";
	}
	
	
	

}
