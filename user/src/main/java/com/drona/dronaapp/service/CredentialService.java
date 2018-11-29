package com.drona.dronaapp.service;

import com.drona.dronaapp.model.Credential;
import com.drona.dronaapp.repo.CredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialService {
    @Autowired
    CredentialRepo credentialRepo;

    public void addCred(Credential credential) {
        credentialRepo.save(credential);
    }

    public Boolean validateLogin(String userName, String password) {
        return credentialRepo.findByUserName(userName).getPassword().equals(password);
    }

    public Boolean updatePassword(String userName, String password) {
        Credential credential = credentialRepo.findByUserName(userName);
        if (!credential.getPassword().equals(password)) {
            credential.setPassword(password);
            credentialRepo.save(credential);
            return true;
        } else {
            return false;
        }
    }


}
