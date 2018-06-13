package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRep;
	
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "admin_users/userForm";
	}
	@PostMapping("/form")
	public String formPost(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "admin_users/userForm";
		}
		this.userRep.save(user);
		return "redirect:/user/userList";
	}
		
	@GetMapping("/userList")
	public String userList() {
		return "admin_users/userList";
	}
	
	
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable long id, Model model) {
		User user = this.userRep.findUserById(id);
		model.addAttribute("user", user);
		return "admin_users/userForm";
	}

	@PostMapping("/{id}/edit")
	public String editPost(@PathVariable long id, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "admin_users/userForm";
		}
		User u = this.userRep.findUserById(id);
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setLogin(user.getLogin());
		u.setPassword(user.getPassword());
		u.setEmail(user.getEmail());
		u.setDateOfBirth(user.getDateOfBirth());
		u.setAdmin(user.isAdmin());
		this.userRep.save(u);
		return "redirect:/user/userList";
	}
	
	@GetMapping("/{id}/del")
	public String del(@PathVariable long id) {
		this.userRep.delete(id);
		return "redirect:/user/userList";
	}
	
	@ModelAttribute("users")
	public List<User> getUsers() {
		return this.userRep.findAll(new Sort(Sort.Direction.ASC, "login"));
	}
	
}
