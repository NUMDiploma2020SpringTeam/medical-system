package microservices.diplom.medicalsystem.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import microservices.diplom.medicalsystem.authentication.service.HospitalUserService;

@RestController
public class UserController {
	
	@Autowired
	HospitalUserService hospitalUserService;
	
}
