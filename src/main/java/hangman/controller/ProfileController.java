package hangman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hangman.entity.User;
import hangman.security.UserRepositoryUserDetailsService;

@Controller
@RequestMapping("/Profile")
public class ProfileController {

	@Autowired
	UserRepositoryUserDetailsService userRepoService;
	
	@GetMapping
	public String getProfile(@AuthenticationPrincipal User user, Model model, String username) {
		
		
		
		model.addAttribute("user",  user.getUsername());
		
		return "Profile";
	}
	
}
