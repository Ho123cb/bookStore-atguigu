package com.bookStore.dao;

import com.bookStore.pojo.User;

public interface UserDAO {
    public User getUserByIdAndpwdDAO(String uname, String pwd);
    public void addUser(User user);
    public String getUserName(String uname);
}
