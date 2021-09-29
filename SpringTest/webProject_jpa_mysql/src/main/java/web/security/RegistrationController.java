package web.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.data.UserRepository;
import web.domain.User;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	private UserRepository userRepo;
	  private PasswordEncoder passwordEncoder;

	  public RegistrationController(
	      UserRepository userRepo, PasswordEncoder passwordEncoder) {
	    this.userRepo = userRepo;
	    this.passwordEncoder = passwordEncoder;
	  }
	  
	  @GetMapping
	  public String registerForm() {
	    return "registration";
	  }
	  
	  @PostMapping
	  public String processRegistration(RegistrationForm form) {
		  User t = form.toUser(passwordEncoder);
		  System.out.println(t.toString());
		  userRepo.save(t);
		  return "redirect:/login";
	  }
}
