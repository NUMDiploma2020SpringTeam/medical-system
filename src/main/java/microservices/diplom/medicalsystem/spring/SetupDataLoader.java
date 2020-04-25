package microservices.diplom.medicalsystem.spring;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import microservices.diplom.medicalsystem.authentication.domain.Privilege;
import microservices.diplom.medicalsystem.authentication.domain.Role;
import microservices.diplom.medicalsystem.authentication.domain.User;
import microservices.diplom.medicalsystem.authentication.repository.PrivilegeRepository;
import microservices.diplom.medicalsystem.authentication.repository.RoleRepository;
import microservices.diplom.medicalsystem.authentication.repository.UserRepository;
import microservices.diplom.medicalsystem.authentication.service.HospitalUserService;
import microservices.diplom.medicalsystem.authentication.service.PrivilegeService;
import microservices.diplom.medicalsystem.authentication.service.RoleService;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;
	
	@Autowired
	private HospitalUserService hospitalUserService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		if(alreadySetup) return;
		
		final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		final Privilege editPrivilege = createPrivilegeIfNotFound("EDIT_PRIVILEGE");
		
		final List<Privilege> doctorPrivileges = Arrays.asList(readPrivilege, writePrivilege, editPrivilege);
		final Role doctorRole = createRoleIfNotFound("ROLE_DOCTOR", doctorPrivileges);
		createRoleIfNotFound("ROLE_NURSE", Arrays.asList(readPrivilege));
		
		createUserIfNotFound("Test", "Test", "developer", passwordEncoder.encode("somepass"), Arrays.asList(doctorRole));
		
		alreadySetup = true;
	}
	
	@Transactional
	private Privilege createPrivilegeIfNotFound(String name) {
		
		Privilege privilege = privilegeRepository.findByName(name);
		if(privilege == null) privilege = privilegeService.createNewPrivilege(name);
		return privilege;
	}
	
	@Transactional
	private Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
		
		Role role = roleRepository.findByName(name);
		if(role == null) {
			role = roleService.createNewRole(name);
			role.setPrivileges(privileges);
		}
		return role;
	}
	
	@Transactional
    private final User createUserIfNotFound(final String firstName, final String lastName, final String username, final String password, final Collection<Role> roles) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
        	user = hospitalUserService.registerNewUserAccount(firstName, lastName, username, password, true);
            user.setRoles(roles);
        }
        return user;
    }

}
