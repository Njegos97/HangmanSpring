package hangman.data;

import hangman.entity.User;

public interface UserRepository {

	 User save(User user);
	 
	 User findByUsername(String username);
	
}
