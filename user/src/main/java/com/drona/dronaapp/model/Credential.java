package com.drona.dronaapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("credential")
public class Credential implements Serializable {

    private static final long serialVersionUID = -9194498895266989124L;
    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;

    private String password;
}
