package pl.edu.wat.flatmates.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.flatmates.beans.User;
import pl.edu.wat.flatmates.dto.FlatDTO;
import pl.edu.wat.flatmates.security.JWTAuthorizationFilter;
import pl.edu.wat.flatmates.service.UserService;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users/sign-up",
            method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> signUp(@RequestBody User user) {
        try{
            userService.signUp(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User with provided data already exists");
        }
            return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user/flat",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> joinFlat(FlatDTO flatDTO){
            try{
                userService.joinFlat(flatDTO);
                return ResponseEntity.ok().build();

            } catch (Exception e){
                log.error("Internal Error",e);
                return ResponseEntity.badRequest().build();
            }
        }


}
