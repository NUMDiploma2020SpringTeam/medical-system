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

	private final String firstName, lastName;
	private final Date dateOfBirthday;
	
	protected Patient() {
		firstName = null;
		lastName = null;
		dateOfBirthday = null;
	}
}
