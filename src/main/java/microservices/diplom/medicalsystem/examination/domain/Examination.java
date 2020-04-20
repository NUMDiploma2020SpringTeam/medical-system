package microservices.diplom.medicalsystem.examination.domain;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import microservices.diplom.medicalsystem.registration.domain.Patient;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class Examination {

	private final Patient patient;
	private final Date dateExaminedOn;
}
