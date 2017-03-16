package com.sasi.junitlearn;

public enum StatusConstant {
	OPEN("Open");
	private String status;
	
	StatusConstant(String status){
		this.status =status;
	}
	
	@Override
	public String toString() {	
		return status;
	}
	
	
}




