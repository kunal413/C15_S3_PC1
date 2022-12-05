package com.niit.jap.rabbitmq;

import org.springframework.data.annotation.Id;

public class CommonUser {
    private int userId;
    private String emailId;
    private String userPassword;
    private String userName;
    private String phoneNo;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public CommonUser(int userId, String emailId, String userPassword, String userName, String phoneNo) {
        this.userId = userId;
        this.emailId = emailId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.phoneNo = phoneNo;
    }

    public CommonUser() {
    }

    @Override
    public String toString() {
        return "CommonUser{" +
                "userId=" + userId +
                ", emailId='" + emailId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
