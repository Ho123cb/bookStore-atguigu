package com.bookStore.service;

import com.bookStore.pojo.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    public User getUserByIdAndPwd(Integer id, String pwd);
}
