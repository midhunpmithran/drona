package com.drona.dronaapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"password"})
@Data
@Document("user")
public class User implements Serializable {

    private static final long serialVersionUID = -5873914760717296339L;
    @Id
    private String id;

    @Field("createdDate")
    private Date createdDate;

    @Field("firstName")
    private String firstName;

    @Field("lastName")
    private String lastName;

    @Field("userName")
    @Indexed(unique = true)
    private String userName;

    @Field("password")
    private String password;

}
