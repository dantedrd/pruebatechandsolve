package com.techandsolve.prueba.pruebatechandsolve.models;

public class ResponseError {
	private String error;
	
	
	public ResponseError() {
		
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ResponseError [error=" + error + "]";
	}
	
	

}
