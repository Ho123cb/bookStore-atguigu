package com.bookStore.service.Impl;

import com.bookStore.dao.UserDAO;
import com.bookStore.pojo.User;
import com.bookStore.service.UserService;

import javax.servlet.http.HttpSession;

public class UserServiecImpl implements UserService {
    UserDAO userDAO;
    @Override
    public User getUserByIdAndPwd(String uname, String pwd) {
        return userDAO.getUserByIdAndpwdDAO(uname, pwd);
    }
}
