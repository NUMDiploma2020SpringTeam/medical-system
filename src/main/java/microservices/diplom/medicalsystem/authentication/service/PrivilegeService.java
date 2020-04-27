package microservices.diplom.medicalsystem.authentication.service;

import microservices.diplom.medicalsystem.authentication.domain.Privilege;
/**
 * Privilege Service interface
 * @author F I R E
 *
 */
public interface PrivilegeService {
	Privilege createNewPrivilege(String name);
}
