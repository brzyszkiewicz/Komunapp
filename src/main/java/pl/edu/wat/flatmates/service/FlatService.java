package pl.edu.wat.flatmates.service;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.flatmates.beans.Flat;
import pl.edu.wat.flatmates.beans.User;
import pl.edu.wat.flatmates.dto.FlatDTO;
import pl.edu.wat.flatmates.repository.FlatRepository;
import pl.edu.wat.flatmates.repository.UserRepository;
import pl.edu.wat.flatmates.utils.UserUtils;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;

@Service
public class FlatService {

    @Autowired
    FlatRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserUtils userUtils;

    public Integer createFlat(FlatDTO details) throws Exception{
        String hash;
        Flat flat = new Flat();
        Integer flatId;
        User user;

        if(details != null && !details.getPass().isEmpty() && !details.getFlatName().isEmpty()){
            hash = Hashing.sha256().hashString(details.getPass(), StandardCharsets.UTF_8).toString();

            flat.setFlatname(details.getFlatName());
            flat.setFlatpasshash(hash);
            flat.setCreatedate(Calendar.getInstance().getTime());
            flat.setCreatedby(userUtils.getCurrentUser().getUserid());
            flat =  repository.save(flat);

            user = userRepository.findByLogin(userUtils.getCurrentUser().getLogin());
            user.setFlatid(flat);
            userRepository.save(user);

            return flat.getFlatid();

        } else
            throw new IllegalArgumentException("Details object is null");

    }

    public Integer getFlatId(){
        if(userUtils.getCurrentUser().getFlatid() == null){
            return null;
        }
        return userUtils.getCurrentUser().getFlatid().getFlatid();
    }
}
