package microservices.diplom.medicalsystem.authentication.service;

import microservices.diplom.medicalsystem.authentication.domain.Role;
/**
 * Role Service interface
 * @author F I R E
 *Creates roles
 */
public interface RoleService {
	Role createNewRole(String name);
}
