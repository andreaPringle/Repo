package net.codejava.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginConfig {
	@RequestMapping("/Login")
	public String defectDetails() {
	    return "Login"; 
	}
}
