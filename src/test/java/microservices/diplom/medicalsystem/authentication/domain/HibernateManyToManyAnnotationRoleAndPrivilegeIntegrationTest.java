package microservices.diplom.medicalsystem.authentication.domain;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import microservices.diplom.medicalsystem.authentication.service.HospitalUserService;
import microservices.diplom.medicalsystem.authentication.service.PrivilegeService;
import microservices.diplom.medicalsystem.authentication.service.RoleService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HibernateManyToManyAnnotationRoleAndPrivilegeIntegrationTest {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private HospitalUserService hospitalUserService;
	
	@Test
	public void givenDataWhenInsertThenCreatesMtoMRelationship() {
		
		Privilege readPrivilege = privilegeService.createNewPrivilege("READ_PRIVILEGE");
		Privilege writePrivilege = privilegeService.createNewPrivilege("WRITE_PRIVILEGE");
		Privilege editPrivilege = privilegeService.createNewPrivilege("EDIT_PRIVILEGE");
		
		Role doctorRole = roleService.createNewRole("ROLE_DOCTOR");
		doctorRole.setPrivileges(Arrays.asList(writePrivilege, editPrivilege));
		Role nurseRole = roleService.createNewRole("ROLE_NURSE");
		nurseRole.setPrivileges(Arrays.asList(readPrivilege));

		User user = hospitalUserService.registerNewUserAccount("Test", "Test", "developer", "somepass", true);
		user.setRoles(Arrays.asList(doctorRole, nurseRole));
		
		assertEquals(3, doctorRole.getPrivileges().size());
		assertEquals(2, user.getRoles().size());
	}
	
}
