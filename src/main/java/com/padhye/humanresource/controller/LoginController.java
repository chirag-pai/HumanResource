package com.padhye.humanresource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.padhye.humanresource.model.User;
import com.padhye.humanresource.repositories.UserDao;



@Controller
public class LoginController {
	
	@GetMapping(value = "/")
	public String loadLoginPage(Model model) {
		model.addAttribute("User", new User());
		return "login/homePage";
	}
	
	@PostMapping(value = "/verifyUser")
	public String verifyUserCredentials(@ModelAttribute User user,Model model) {
		boolean isValid = false;
		UserDao daoObj = new UserDao();
		isValid = daoObj.isUserValid(user.getUserName(), user.getPassword());
		if(!isValid) {
			model.addAttribute("error", "Please verify UserName and Password and try again.");
			model.addAttribute("User", new User());
			return "login/homePage";
		}
		return "redirect:/loadDashboard";
	}
}
