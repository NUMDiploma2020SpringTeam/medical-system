package microservices.diplom.medicalsystem.authentication.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservices.diplom.medicalsystem.authentication.domain.Privilege;
import microservices.diplom.medicalsystem.authentication.repository.PrivilegeRepository;

@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	@Autowired
	public PrivilegeServiceImpl(final PrivilegeRepository privilegeRepository) {
		this.privilegeRepository = privilegeRepository;
	}

	@Override
	public Privilege createNewPrivilege(String name) {
		return privilegeRepository.save(new Privilege(name));
	}
	
}
