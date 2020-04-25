package microservices.diplom.medicalsystem.authentication.service;

import microservices.diplom.medicalsystem.authentication.domain.User;
import microservices.diplom.medicalsystem.authentication.error.UserAlreadyExistException;

public interface HospitalUserService {
	User registerNewUserAccount(String firstName, String lastName, String username, String password, boolean enabled) throws UserAlreadyExistException;
}
