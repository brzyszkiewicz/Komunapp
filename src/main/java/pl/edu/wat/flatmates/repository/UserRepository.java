package pl.edu.wat.flatmates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wat.flatmates.beans.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
