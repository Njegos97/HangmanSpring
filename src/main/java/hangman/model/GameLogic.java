package hangman.model;

import hangman.entity.Game;

public class GameLogic {


	public static String makeWordPattern(Game game, String playedLetter) {
		String word = game.getWord();
		String wordPattern = game.getWordPattern();
		char[] wordCharacters = wordPattern.toCharArray();
	
		for(int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if(playedLetter.equals(Character.toString(letter))) {
				
				wordCharacters[i] = letter;
			
			}
		
			
		}
		if (!word.contains(playedLetter)) {
			int points = game.getPoints() - 10;
			game.setPoints(points);
			
			
		}
		
		
		
	    wordPattern = String.valueOf(wordCharacters);
	    if(!wordPattern.contains("*")) {
			game.setGameFinished(true);
		}
		game.setWordPattern(wordPattern);
		
		return wordPattern;
	}
	

	
	public static String hideWord(String word) {
		String hideWord = "";
		for(int i = 0; i < word.length(); i++) {
			hideWord += "*";
		}
		
		return hideWord;
	}
	
	
	
	
}
