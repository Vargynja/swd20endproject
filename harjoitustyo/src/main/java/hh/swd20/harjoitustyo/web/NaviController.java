package hh.swd20.harjoitustyo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NaviController {

	@RequestMapping("/index")
	public String homePage() {
		return "index";
	}
}
