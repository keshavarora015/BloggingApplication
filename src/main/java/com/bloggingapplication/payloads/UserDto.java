package com.bloggingapplication.payloads;

import javax.validation.constraints.*;

public class UserDto {

    private Integer id;

    @NotEmpty
    @Size(min = 3,message = "Name Must be of 3 Characters")
    private String name;

    @NotEmpty
    @Email(message = "Please Enter a valid Email!!")
    private String email;

    @NotEmpty
    @Size(min = 5, max = 10)
    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{5,10}$", message = "Password must contain at least one digit [0-9]." +
            "Password must contain at least one lowercase Latin character [a-z]." +
            "Password must contain at least one uppercase Latin character [A-Z]." +
            "Password must contain at least one special character like ! @ # & ( )." +
            "Password must contain a length of at least 5 characters and a maximum of 10 characters.")
    private String password;

    @NotEmpty
    private String about;

    public UserDto() {
        super();
    }

    public UserDto(Integer id, String name, String email, String password, String about) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.about = about;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
