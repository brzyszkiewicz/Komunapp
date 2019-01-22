package pl.edu.wat.flatmates.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.flatmates.beans.User;
import pl.edu.wat.flatmates.repository.UserRepository;
import pl.edu.wat.flatmates.security.JWTAuthorizationFilter;

@Component
public class UserUtils {

    @Autowired
    UserRepository repository;

    public User getCurrentUser(){
        String login = JWTAuthorizationFilter.getUsername();

        return repository.findByLogin(login);
    }
}
