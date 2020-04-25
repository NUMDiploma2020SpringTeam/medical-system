package microservices.diplom.medicalsystem.authentication.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservices.diplom.medicalsystem.authentication.domain.Role;
import microservices.diplom.medicalsystem.authentication.repository.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	public RoleServiceImpl(final RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Role createNewRole(String name) {
		return roleRepository.save(new Role(name));
	}

}
