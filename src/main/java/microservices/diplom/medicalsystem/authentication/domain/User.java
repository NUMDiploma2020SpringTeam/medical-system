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

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "users")
public final class User {
	
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long id;
	
	private final String firstName, lastName, username, password;
	private final boolean enabled;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "user_roles",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")}
	)
	private Collection<Role> roles;
	
	protected User() {
		this(null, null, null, null, false);
	}
	
	public void addRole(Role role) {
		roles.add(role);
	}
}
