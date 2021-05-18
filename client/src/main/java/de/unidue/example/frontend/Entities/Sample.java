package de.unidue.example.frontend.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sample {

    private int id;
    private String username;
    private String password;

    @JsonCreator
    public Sample(@JsonProperty("id") int id,
                  @JsonProperty("username") String username,
                  @JsonProperty("password") String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Sample(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
