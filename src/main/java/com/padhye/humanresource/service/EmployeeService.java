package com.padhye.humanresource.service;

import com.padhye.humanresource.model.Employee;

public class EmployeeService {

	
	public String isEmployeeDataValid(Employee emp) {
		if(emp.getEmployeeId() <= 0) {
			return "Incorrect Employee selected.";
		}
		if(emp.getReason() == null || emp.getReason().trim().length() == 0) {
			return "Enter valid reason and try again.";
		}
		if(emp.getFromDate() == null) {
			return "Enter valid from date.";
		}
		if(emp.getToDate() == null) {
			return "Enter valid to date.";
		}
		return "success";
	}
}
