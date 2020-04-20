package microservices.diplom.medicalsystem.registration.domain;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class Patient {

	private final String firstName, lastName, register, gender, address, work;
	private final Date dateOfBirth;
	public Patient() {
		firstName = null;
		lastName = null;
		dateOfBirth = null;
		register = null;
		gender = null;
		address = null;
		work = null;
	}
	
	public Patient(String firstName, String lastName, String register, String gender, Date dateOfBirth, 
			String address, String work) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.register = register;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.work = work;
	}
}
