package hangman.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import hangman.entity.User;
import lombok.Data;
@Data
public class RegistrationForm {

	private String email;
	private String username;
	private String password;
	
	public User toUser(PasswordEncoder passwordEncoder) {
		User user = new User();
		user.setEmail(this.email);
		user.setUsername(this.username);
		user.setPassword(passwordEncoder.encode(this.password));
		user.setAuthority(User.Authority.ROLE_USER);
		user.setEnabled(true);
		return user;
	}
	
}
