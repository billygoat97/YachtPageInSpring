package yacht.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import yacht.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}