package microservices.diplom.medicalsystem.authentication.service;

import microservices.diplom.medicalsystem.authentication.domain.Privilege;

public interface PrivilegeService {
	Privilege createNewPrivilege(String name);
}
