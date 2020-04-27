package microservices.diplom.medicalsystem.authentication.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * @author F I R E
 *Role Class
 *	Users can have multiple roles
 *	On our case there are two types of role of Doctor and Nurse
 *	Each role can has multiple privileges
 *	
 */
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "roles")
public final class Role {

	@Id
	@GeneratedValue
	@Column(name = "ROLE_ID")
	private Long id;
	
	private final String name;
	
	@ManyToMany(mappedBy = "roles")
	private Collection<User> users;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "roles_privileges",
			joinColumns = {@JoinColumn(name = "role_id")},
			inverseJoinColumns = {@JoinColumn(name = "privilege_id")}
	)
    private Collection<Privilege> privileges;
	
	protected Role() {
		this(null);
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void addPrivilege(Privilege privilege) {
		privileges.add(privilege);
	}
	
}
