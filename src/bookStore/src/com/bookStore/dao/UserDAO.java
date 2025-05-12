package com.bookStore.dao;

import com.bookStore.pojo.User;

public interface UserDAO {
    public User getUserByIdAndpwdDAO(String uname, String pwd);
}
