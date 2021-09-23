package yacht.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;
import yacht.User;

@Data
public class RegistrationForm {
	
	private String username;
	private String pwd;
	private String fullname;
	private String email;
	private String phone;
	
	public User toUser(PasswordEncoder passwordEncoder) {
		return new User(
				username, passwordEncoder.encode(pwd),
				fullname, email, phone);
	}
}