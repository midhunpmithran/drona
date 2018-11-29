package com.drona.dronaapp.repo;

import com.drona.dronaapp.model.Credential;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepo extends MongoRepository<Credential, String> {
    Credential findByUserName(String userName);
}
