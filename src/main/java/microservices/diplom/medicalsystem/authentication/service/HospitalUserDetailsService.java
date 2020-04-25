package microservices.diplom.medicalsystem.authentication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import microservices.diplom.medicalsystem.authentication.domain.Privilege;
import microservices.diplom.medicalsystem.authentication.domain.Role;
import microservices.diplom.medicalsystem.authentication.domain.User;
import microservices.diplom.medicalsystem.authentication.repository.RoleRepository;
import microservices.diplom.medicalsystem.authentication.repository.UserRepository;

@Service("userDetailsService")
@Transactional
public class HospitalUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	public HospitalUserDetailsService(final UserRepository userRepository, final HospitalUserService service, final RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		if(user == null) {
			return new org.springframework.security.core.userdetails.User(
		              " ", " ", true, true, true, true, 
		              getAuthorities(Arrays.asList(roleRepository.findByName("ROLE_DOCTOR"))));
		}
		
		return new org.springframework.security.core.userdetails.User(
		          user.getUsername(), user.getPassword(), user.isEnabled(), true, true, 
		          true, getAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
		return getGrantedAuthorities(getPrivileges(roles));
	}
	
	private List<String> getPrivileges(Collection<Role> roles) {
		
		List<String> privileges = new ArrayList<>();
		List<Privilege> collection = new ArrayList<>();
		for(Role role: roles) collection.addAll(role.getPrivileges());
		for(Privilege item: collection) privileges.add(item.getName());
		return privileges;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(String privilege: privileges) authorities.add(new SimpleGrantedAuthority(privilege));
		return authorities;
	}
	
	
}
