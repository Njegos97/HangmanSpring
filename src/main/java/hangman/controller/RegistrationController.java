package hangman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hangman.data.UserRepository;
import hangman.security.RegistrationForm;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	
	@PostMapping
	public String processRegistration(RegistrationForm registrationForm) {
		userRepo.save(registrationForm.toUser(passwordEncoder));
		return "redirect:/";
	}
	
	
}
