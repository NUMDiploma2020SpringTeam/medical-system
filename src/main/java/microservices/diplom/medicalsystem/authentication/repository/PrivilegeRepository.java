package microservices.diplom.medicalsystem.authentication.repository;

import org.springframework.data.repository.CrudRepository;

import microservices.diplom.medicalsystem.authentication.domain.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
	Privilege findByName(final String name);
}
