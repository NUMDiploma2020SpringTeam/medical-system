package microservices.diplom.medicalsystem.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.diplom.medicalsystem.authentication.service.HospitalUserService;
import microservices.diplom.medicalsystem.security.ActiveUserStore;

@RestController
public class UserController {
	
	@Autowired
	ActiveUserStore activeUserStore;
	
	@Autowired
	HospitalUserService hospitalUserService;
	
	@GetMapping("/loggedUsers")
	public String getLoggedUsers() {
		return activeUserStore.getUsers().toString();
	}

}
