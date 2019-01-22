package pl.edu.wat.flatmates.service;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import pl.edu.wat.flatmates.beans.Flat;
import pl.edu.wat.flatmates.beans.User;
import pl.edu.wat.flatmates.dto.FlatDTO;
import pl.edu.wat.flatmates.repository.FlatRepository;
import pl.edu.wat.flatmates.repository.UserRepository;
import pl.edu.wat.flatmates.utils.UserUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private FlatRepository flatRepository;
    @Autowired
    private UserUtils userUtils;


    //User(Integer userid, String firstname, String lastname, String login, String passwordhash, String email)
    public void signUp(User user) {
        user.setPasswordhash(bCryptPasswordEncoder.encode(user.getPasswordhash()));
        userRepository.save(user);
    }

    public void joinFlat(FlatDTO flatDTO) throws Exception{
        Flat flat;
        User currentUser;
        String passHash;

        currentUser = userUtils.getCurrentUser();

        if(flatDTO != null && !flatDTO.getFlatName().isEmpty() && !flatDTO.getPass().isEmpty()){
            flat = flatRepository.findByFlatname(flatDTO.getFlatName());
            passHash = Hashing.sha256().hashString(flatDTO.getPass(), StandardCharsets.UTF_8).toString();
            if(flat != null){
                if(passHash.equals(flat.getFlatpasshash())){
                    currentUser.setFlatid(flat);
                    userRepository.save(currentUser);
                }
                else throw new Exception("Wrong credentials");
            } else throw new Exception("Wrong credentials");

        }
    }



}
