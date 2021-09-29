package web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import web.data.UserRepository;
import web.domain.User;

@Service
public class UserRepositoryService implements UserDetailsService {
	
	private UserRepository userRepo;
	
	@Autowired
	public UserRepositoryService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user != null) {
			System.out.print("Load username : ");
			System.out.println(user.toString());
			return user;
		}
		throw new UsernameNotFoundException("User '" + username + "' not found");
	}
	
}
