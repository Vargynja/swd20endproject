package hh.swd20.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hh.swd20.harjoitustyo.domain.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userrepo;
	
	@GetMapping("/u/{id}")
	public String userPage(@PathVariable Long id, Model model) {
		model.addAttribute("user",userrepo.findById(id).get());
		return "user";
	}

}
