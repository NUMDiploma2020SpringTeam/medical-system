package microservices.diplom.medicalsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * 
 * @author F I R E
 *Medical System Web Application
 *	
 */
@SpringBootApplication
public class MedicalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalSystemApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
