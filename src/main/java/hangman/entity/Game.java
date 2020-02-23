package hangman.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Game {

	 User user;
	 String word;
	 String wordPattern;
     boolean gameFinished;
	 int points = 60;
	
	
}
