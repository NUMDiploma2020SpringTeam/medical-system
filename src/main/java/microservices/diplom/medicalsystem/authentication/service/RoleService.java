package microservices.diplom.medicalsystem.authentication.service;

import microservices.diplom.medicalsystem.authentication.domain.Role;

public interface RoleService {
	Role createNewRole(String name);
}
