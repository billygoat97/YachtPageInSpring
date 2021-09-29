package web.security;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;
import web.domain.User;

@Data
public class RegistrationForm {

	private String username;
	private String password;
	private String fullName;
	private String email;
	private String phoneNumber;
  
	public User toUser(PasswordEncoder passwordEncoder) {
		return new User(username, passwordEncoder.encode(password), fullName, email, phoneNumber);
	}
  
}
