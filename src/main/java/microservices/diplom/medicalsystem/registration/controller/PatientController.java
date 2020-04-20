package microservices.diplom.medicalsystem.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.diplom.medicalsystem.registration.service.PatientService;

@RestController
@RequestMapping("/patients")
final class PatientController {
	
	private final PatientService patientService;
	
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
}
