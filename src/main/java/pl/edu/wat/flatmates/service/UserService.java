package pl.edu.wat.flatmates.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.wat.flatmates.beans.User;
import pl.edu.wat.flatmates.repository.UserRepository;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //User(Integer userid, String firstname, String lastname, String login, String passwordhash, String email)
    public void signUp(User user) {
        user.setPasswordhash(bCryptPasswordEncoder.encode(user.getPasswordhash()));
        userRepository.save(user);
    }



}
