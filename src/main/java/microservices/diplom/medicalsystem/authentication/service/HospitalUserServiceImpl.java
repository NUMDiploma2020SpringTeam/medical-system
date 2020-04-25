package microservices.diplom.medicalsystem.authentication.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservices.diplom.medicalsystem.authentication.domain.User;
import microservices.diplom.medicalsystem.authentication.error.UserAlreadyExistException;
import microservices.diplom.medicalsystem.authentication.repository.UserRepository;

@Service
@Transactional
public class HospitalUserServiceImpl implements HospitalUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	public HospitalUserServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	@Override
	public User registerNewUserAccount(String firstName, String lastName, String username, String password, boolean enabled) throws UserAlreadyExistException {
		if(usernameExists(username)) {
			throw new UserAlreadyExistException("There is an account with that username: " + username);
		}
		
		final User user = new User(lastName, firstName, username, password, enabled);
		return userRepository.save(user);
	}
	
	private boolean usernameExists(final String username) {
		return userRepository.findByUsername(username) != null;
	}

}
