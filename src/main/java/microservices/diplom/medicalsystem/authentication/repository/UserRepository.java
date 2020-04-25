package microservices.diplom.medicalsystem.authentication.repository;

import org.springframework.data.repository.CrudRepository;

import microservices.diplom.medicalsystem.authentication.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(final String username);
}
