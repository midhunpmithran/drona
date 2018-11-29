package com.drona.dronaapp.repo;

import com.drona.dronaapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    User findByUserName(String userName);

    void deleteByUserName(String userName);
}
