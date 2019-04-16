package hh.swd20.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd20.harjoitustyo.domain.GenreRepository;

@Controller
public class NaviController {

	@Autowired
	private  GenreRepository genrerepo;
	
	@GetMapping("/index")
	public String homePage(Model model) {
		model.addAttribute("genres", genrerepo);
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
