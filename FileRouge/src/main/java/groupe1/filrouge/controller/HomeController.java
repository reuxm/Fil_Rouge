package groupe1.filrouge.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    String index(Principal principal) {
        return "home";
    }
    
    @GetMapping(value = "/403")
	public String accesssDenied(Principal user) {
		return "homeErr";

	}

}