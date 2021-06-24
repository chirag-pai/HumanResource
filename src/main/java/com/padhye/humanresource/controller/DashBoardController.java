package com.padhye.humanresource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.padhye.humanresource.model.Employee;
import com.padhye.humanresource.model.Reports;
import com.padhye.humanresource.repositories.EmployeeDao;

@Controller
public class DashBoardController {

	@GetMapping(value = "/loadDashboard")
	public String loadDashboard() {
		return "login/dashboard";
	}
	
	@GetMapping(value = "/LeaveManagement")
	public String loadEmployeeLeaveForm(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", new EmployeeDao().getNonAdminUserList());
		return "leaves/manageLeave";
	}
	
	@GetMapping(value = "/reports")
	public String loadViewReportsForm(Model model) {
		model.addAttribute("report", new Reports());
		return "report/viewReports";
	}
	
}
