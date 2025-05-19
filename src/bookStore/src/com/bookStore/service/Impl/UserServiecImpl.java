package com.bookStore.service.Impl;

import com.atguigu.myssm.util.StringUtil;
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

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public boolean verifyUname(String uname) {
        return StringUtil.isNotEmpty(userDAO.getUserName(uname));
    }
}
