package hangman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import hangman.data.WordsRepository;
import hangman.entity.Game;
import hangman.model.GameLogic;

@Controller
@RequestMapping("/game")
@SessionAttributes("game")
public class GameController {

	@Autowired
	WordsRepository wordsRepo;
	
	@ModelAttribute("game")
	public Game game() {
		Game game = new Game();
		return  game;
	}
	
	@GetMapping
	public String newGame(@ModelAttribute("game") Game game) {
		game.setWord(wordsRepo.getRandomWord());
		game.setWordPattern(GameLogic.hideWord(game.getWord()));
		game.setPoints(60);
		game.setGameFinished(false);
		return "game";
	}
	
	@PostMapping
	public String playGame(@RequestParam String letter, @ModelAttribute("game") Game game) {
		game.setWordPattern(GameLogic.makeWordPattern(game, letter));
		return "game";
	}
	
	@GetMapping("/show")
	public String showGame() {
		return "game";
	}
	
	@GetMapping("/quitGame")
	public String quitGame(Model model, Game game) {
	    
		
		return "redirect:/Profile";
	}
}
