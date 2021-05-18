package de.unidue.example.frontend.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sample {

    private int id;
    private String username;
    private String password;
    private Type type;
    private String fileName;
    private String base64String;

    @JsonCreator
    public Sample(@JsonProperty("id") int id,
                  @JsonProperty("username") String username,
                  @JsonProperty("password") String password,
                  @JsonProperty("type") Type type,
                  @JsonProperty("fileName") String fileName,
                  @JsonProperty("base64String") String base64String){
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.fileName = fileName;
        this.base64String = base64String;
    }

    public Sample(String username, String password, Type type, String base64String, String fileName) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.base64String = base64String;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBase64String() {
        return base64String;
    }

    public void setBase64String(String base64String) {
        this.base64String = base64String;
    }
}
