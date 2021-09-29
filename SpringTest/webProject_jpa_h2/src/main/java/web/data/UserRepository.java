package web.data;

import org.springframework.data.repository.CrudRepository;

import web.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}

