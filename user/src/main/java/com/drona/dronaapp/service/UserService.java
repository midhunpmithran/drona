package com.drona.dronaapp.service;

import com.drona.dronaapp.exception.UserAuthException;
import com.drona.dronaapp.exception.UserException;
import com.drona.dronaapp.exception.UserNotFoundException;
import com.drona.dronaapp.model.User;
import com.drona.dronaapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public void addUser(User user) {

        user.setCreatedDate(new Date());
        try {
            userRepo.save(user);
        } catch (Exception e) {
            throw new UserException("Unable to add user");
        }

    }

    /*public void addUser(Map<String, Object> payload){
        User user = new User("",new Date(),payload.get("firstName").toString(),payload.get("lastName").toString(),payload.get("userName").toString());
        userRepo.save(user);
    }*/

    public User findByUserName(String userName) {
        User user = userRepo.findByUserName(userName);
        if (user != null) {
            return user;
        }
        throw new UserNotFoundException(userName);
    }

    public Boolean verifyLogin(String userName, String password) {
        try {
            if (userRepo.findByUserName(userName).getPassword().equals(password)) {
                return true;
            } else {
                throw new UserAuthException("Password Miss Match");
            }
        } catch (NullPointerException e) {
            throw new UserAuthException("Invalid user name");
        }

    }

    /*public boolean removeUser(String userName) {
        try {
            userRepo.delete(userRepo.findByUserName(userName));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }*/

    public void deleteUser(String userName) {
        userRepo.deleteByUserName(userName);
    }


}
