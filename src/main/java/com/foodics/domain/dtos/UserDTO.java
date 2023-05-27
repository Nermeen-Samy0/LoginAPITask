package com.foodics.domain.dtos;

public class UserDTO {

    private String userEmail;
    private String userPassword;

    public UserDTO() { }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

}
