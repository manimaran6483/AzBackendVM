package com.azure;

import java.util.ArrayList;
import java.util.List;

public class Response {

	private List<Employee> result = new ArrayList<>();

	public List<Employee> getResult() {
		return result;
	}

	public void setResult(List<Employee> result) {
		this.result = result;
	}
	
}
