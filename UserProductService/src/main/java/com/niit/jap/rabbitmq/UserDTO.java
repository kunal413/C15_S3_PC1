package com.niit.jap.rabbitmq;

public class UserDTO {
    private  String userPassword;
    private  String emailId;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public UserDTO(String userPassword, String emailId) {
        this.userPassword = userPassword;
        this.emailId = emailId;
    }

    public UserDTO() {
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userPassword='" + userPassword + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
