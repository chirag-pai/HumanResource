package com.padhye.humanresource.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.padhye.humanresource.model.Employee;
import com.padhye.humanresource.repositories.EmployeeDao;
import com.padhye.humanresource.utility.Constants;

@Controller
public class LeaveManagementController {

	
	@PostMapping(value = "/submitLeave", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addLeaveDetails(@ModelAttribute Employee employee) {
		int rowInserted = new EmployeeDao().insertLeaveDetail(employee);
		if(rowInserted > 0) {
			return Constants.SUCCESS;
		}else {
			return Constants.ERROR;
		}
	}
}
