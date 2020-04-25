package microservices.diplom.medicalsystem.authentication.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "privileges")
public final class Privilege {

	@Id
	@GeneratedValue
	@Column(name = "PRIVILEGE_ID")
	private Long id;
	
	private final String name;
	
	@ManyToMany(mappedBy = "privileges")
	private Collection<Role> roles;
	
	protected Privilege() {
		this(null);
	}
    
    public void addRole(Role role) {
    	roles.add(role);
    }
   
}
