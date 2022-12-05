package com.niit.jap.springBootApp.rabbitmqreciver;

public class UserDTO {
    private String emailId;
    private String userPassword;

    public UserDTO(String emailId, String userPassword) {
        this.emailId = emailId;
        this.userPassword = userPassword;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "emailId='" + emailId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public UserDTO() {
    }
}
