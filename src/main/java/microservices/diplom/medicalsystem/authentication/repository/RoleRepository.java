package microservices.diplom.medicalsystem.authentication.repository;

import org.springframework.data.repository.CrudRepository;

import microservices.diplom.medicalsystem.authentication.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByName(final String name);
}
