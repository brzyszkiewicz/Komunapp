package pl.edu.wat.flatmates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.flatmates.beans.User;
import pl.edu.wat.flatmates.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users/sign-up", method = RequestMethod.POST)
        public void signUp(@RequestBody User user) {
            userService.signUp(user);
        }


}
