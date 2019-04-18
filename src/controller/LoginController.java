package controller;

import DAO.UserAccess;
import model.User;

public class LoginController{
    private UserAccess userAccess;

    public LoginController(UserAccess userAccess){
        this.userAccess=userAccess;
    }

    public User login(String username, String password){
        return userAccess.logIn(username,password);
    }

    public void addUser(String username, String password, String phone, String address) {
        User user=new User(username,password,phone,address);
        userAccess.insertUser(user);
    }
}