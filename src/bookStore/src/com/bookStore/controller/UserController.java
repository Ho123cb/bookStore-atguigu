package com.bookStore.controller;

import com.bookStore.pojo.User;
import com.bookStore.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class UserController {

    UserService userService;
    public String login(Integer id, String pwd, HttpSession session) {
        User user = userService.getUserByIdAndPwd(id, pwd);
        if(user != null) {
            session.setAttribute("user", user);
        }
        else {
            return "user/login";
        }
        return "user/login_success";
    }
}
