package pl.coderslab.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {
	 @Autowired
	 UserRepository userRepository;
	 
	 @GetMapping("/login")
	    public String demo() {
	        return "authorization/login";
	}
	 @PostMapping("/login")
	    
	    public String demo(HttpServletRequest request, Model model) {

	        String login = request.getParameter("login");
	        String password = request.getParameter("password");
	        String message;

	        User user = userRepository.findByLogin(login);

	        if (user != null && password.equals(user.getPassword())){  //BCrypt.checkpw
	            HttpSession session = request.getSession();
	            
	            session.setAttribute("login", user.getLogin());
	            session.setAttribute("authorized", true);
	            session.setAttribute("role", "customer");

	            session.setMaxInactiveInterval(30*60);
	            if(user.isAdmin() == true) {
	            return "redirect:/admin";
	            }
	            return "redirect:/"+user.getId()+"/account/profile";
	        }
	        else
	        {
	        	message = "Bledne dane, sprobuj ponownie";
				model.addAttribute("message", message);
	            return "authorization/login";
	        }
	    }

	 @GetMapping("/registration")
		public String form(Model model) {
			model.addAttribute("user", new User());
			return "authorization/registration";
		}
		@PostMapping("/registration")
		public String formPost(@Valid User user, BindingResult result) {
			if(userRepository.findByLogin(user.getLogin())!=null) {
				result.rejectValue("login", "error", "Login alredy taken");
				return "authorization/registration";
			}else if(userRepository.findByEmail(user.getEmail())!=null){
				result.rejectValue("email", "error", "Account for this email already exists");
				return "authorization/registration";
			}
			this.userRepository.save(user);
			return "redirect:/"+user.getId()+"/account/profile";

		}
	 
	 
//		@PostMapping("/registration")
//		public String formPost(@Valid User user, BindingResult result) {
//			if (result.hasErrors()) {
//				return "authorization/registration";
//			}
//			this.userRepository.save(user);
//			return "redirect:/"+user.getId()+"/account/profile";
//		}

	}

