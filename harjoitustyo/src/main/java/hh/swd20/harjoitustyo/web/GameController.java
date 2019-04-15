package hh.swd20.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd20.harjoitustyo.domain.GameRepository;

@Controller
public class GameController {

	   @Autowired
	   private GameRepository gamerepo;
	   
	   @RequestMapping("/gamelist")
	   public String gameslist() {
		   return "gamelist";
	   }
}
