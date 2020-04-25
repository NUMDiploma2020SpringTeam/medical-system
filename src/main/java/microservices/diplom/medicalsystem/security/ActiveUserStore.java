package microservices.diplom.medicalsystem.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ActiveUserStore {

	public List<String> users;
	
	public ActiveUserStore() {
		users = new ArrayList<>();
	}
	
	public List<String> getUsers() {
		return users;
	}
	
	public void setUsers(List<String> users) {
		this.users = users;
	}
}
