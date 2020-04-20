package microservices.diplom.medicalsystem.registration.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservices.diplom.medicalsystem.registration.domain.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	public PatientServiceImpl() {};
	
	@Override
	public Patient createPatient(String firstName, String lastName, String register, 
			String gender, Date dateOfBirth, String address, String work) {
		return new Patient(firstName, lastName, register, gender, dateOfBirth, address, work);
	}

}
