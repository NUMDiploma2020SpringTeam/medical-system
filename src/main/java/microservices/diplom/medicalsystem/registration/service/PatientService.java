package microservices.diplom.medicalsystem.registration.service;

import java.util.Date;

import microservices.diplom.medicalsystem.registration.domain.Patient;

public interface PatientService {
	Patient createPatient(String firstName, String lastName, String register, 
			String gender, Date dateOfBirth, String address, String work);
}
