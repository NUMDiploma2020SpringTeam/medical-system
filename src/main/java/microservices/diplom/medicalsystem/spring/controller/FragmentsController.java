package microservices.diplom.medicalsystem.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {
	
	@GetMapping("/")
	public String getHome() {
		return "index.html";
	}
}
