package com.bookStore.dao;

import com.bookStore.pojo.User;

public interface UserDAO {
    public User getUserByIdAndpwdDAO(Integer id, String pwd);
}
