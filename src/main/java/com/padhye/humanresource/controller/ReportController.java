package com.padhye.humanresource.controller;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.padhye.humanresource.model.Reports;
import com.padhye.humanresource.repositories.ReportsDao;

@Controller
public class ReportController {

	
	@GetMapping(value = "/fetchReport")
	public String fetchLeaveReport(@ModelAttribute Reports report ,Model model) {
		Date fromDate = report.getFromDate();
		Date toDate = report.getToDate();
		ArrayList<Reports> reportList = new ReportsDao().fetchReportBetweenDates(fromDate, toDate);
		model.addAttribute("reportList", reportList);
		return "report/showReport";
	}
}
