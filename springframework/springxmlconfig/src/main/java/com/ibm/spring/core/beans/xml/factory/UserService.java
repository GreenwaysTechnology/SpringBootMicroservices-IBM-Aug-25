package com.ibm.spring.core.beans.xml.factory;

public class UserService {

    private UserService() {

    }

    public String getUserInfo() {
        return "User info";
    }

    public static UserService getInstance() {
        return new UserService();
    }
}