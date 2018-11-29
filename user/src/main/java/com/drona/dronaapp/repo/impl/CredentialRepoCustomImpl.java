package com.drona.dronaapp.repo.impl;


import com.drona.dronaapp.model.Credential;
import com.drona.dronaapp.repo.CredentialRepoCustom;
import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class CredentialRepoCustomImpl implements CredentialRepoCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public int updatePassword(String userName, String password) {
        Query query = new Query(Criteria.where("userName").is(userName));
        UpdateResult writeResult = mongoTemplate.updateFirst(query, Update.update("password", password), Credential.class);
        return 0;
    }
}
