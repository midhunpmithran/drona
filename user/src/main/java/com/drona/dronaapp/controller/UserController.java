package com.drona.dronaapp.controller;

import com.drona.dronaapp.exception.UserNotFoundException;
import com.drona.dronaapp.model.User;
import com.drona.dronaapp.repo.UserRepo;
import com.drona.dronaapp.service.CredentialService;
import com.drona.dronaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CredentialService credentialService;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    User findUser(@PathVariable String userName) {
        return userService.findByUserName(userName);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> findAllUser() {
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    void addUser(@RequestBody User user) {
        System.out.print("Inside AddUser C*");
        userService.addUser(user);
    }

   /* @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    void addUser(@RequestBody Map<String, Object> payload) {

        payload.forEach((key, value)->{
            System.out.println("Key :"+ key + "\t value :"+ value);
        });
        System.out.print("Inside AddUser C*");
        userService.addUser(payload);
    }*/

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    Boolean userLogin(@RequestParam("username") String userName,
                      @RequestParam("password") String password) {

        return userService.verifyLogin(userName, password);

    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
    void userDelete(@PathVariable String userName) {
        userService.deleteUser(userName);
    }

}
