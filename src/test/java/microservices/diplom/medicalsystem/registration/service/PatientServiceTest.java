package microservices.diplom.medicalsystem.registration.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import microservices.diplom.medicalsystem.registration.domain.Patient;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PatientServiceTest {
	
	@Autowired
	private PatientService patientService;
	
	@Test
	public void createPatientTest() throws ParseException {
		Patient patient = patientService.createPatient("First Name", "Last Name", 
				"AB00000000", "Male", new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1998"), "somewhere", "num");
		
		assertThat(patient.getFirstName()).isEqualTo("First Name");
		assertThat(patient.getLastName()).isEqualTo("Last Name");
		assertThat(patient.getRegister()).isEqualTo("AB00000000");
		assertThat(patient.getGender()).isEqualTo("Male");
		assertThat(patient.getDateOfBirth()).isEqualTo(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1998"));
		assertThat(patient.getAddress()).isEqualTo("somewhere");
		assertThat(patient.getWork()).isEqualTo("num");
	}
}
