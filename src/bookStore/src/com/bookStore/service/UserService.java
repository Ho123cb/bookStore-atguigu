package com.bookStore.service;

import com.bookStore.pojo.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    public User getUserByIdAndPwd(String uname, String pwd);
    public void addUser(User user);
    public boolean verifyUname(String uname);
}
