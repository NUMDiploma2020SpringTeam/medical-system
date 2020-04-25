package microservices.diplom.medicalsystem.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.diplom.medicalsystem.registration.domain.Patient;
import microservices.diplom.medicalsystem.registration.service.PatientService;

@RestController
@RequestMapping("/patients")
final class PatientController {
	
	private final PatientService patientService;
	
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@PostMapping
	ResponseEntity<Patient> postResult(@RequestBody Patient patient) {
		return ResponseEntity.ok(patient);
	}
	
}
