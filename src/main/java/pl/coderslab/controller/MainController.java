package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

@Controller
public class MainController {
	@Autowired
	UserRepository userRep;
	
	//To na razie zamiast logowania
	@GetMapping("/user")
	public String userList(Model model) {
		List<User> users = this.userRep.findAll(new Sort(Sort.Direction.ASC, "login"));
		model.addAttribute("users",users);
		return "user";
	}
	
	@GetMapping("/admin")
	public String adminAccount() {
		return "admin";
	}

}
