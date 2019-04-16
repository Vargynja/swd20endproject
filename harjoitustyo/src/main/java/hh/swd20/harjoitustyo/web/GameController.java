package hh.swd20.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd20.harjoitustyo.domain.GameRepository;
import hh.swd20.harjoitustyo.domain.GenreRepository;

@Controller
public class GameController {

	   @Autowired
	   private GameRepository gamerepo;
	   
	   @Autowired
	   private GenreRepository genrerepo; 
	   
	   @RequestMapping("/gamelist")
	   public String gameslist(Model model) {
		   model.addAttribute("genres", genrerepo);
		   model.addAttribute("games", gamerepo);
		   return "gamelist";
	   }
	   
	   @RequestMapping("/gamelist/{id}")
	   public String gamesByGenre(@PathVariable(name = "id")Long id, Model model) {
		   model.addAttribute("genres", genrerepo);
		   model.addAttribute("games", genrerepo.findById(id).get().getGames());
		   return "gamelist";
	   }
}
