package com.bookStore.controller;

import com.bookStore.pojo.User;
import com.bookStore.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class UserController {

    private UserService userService;
    public String login(String uname, String pwd, HttpSession session) {
        User user = userService.getUserByIdAndPwd(uname, pwd);
        if(user != null) {
            session.setAttribute("user", user);
        }
        else {
            return "user/login";
        }
        return "user/login_success";
    }

    public String cookieLogin(String uname, String pwd, HttpSession session) {
        User user = userService.getUserByIdAndPwd(uname, pwd);
        if(user != null) {
            session.setAttribute("user", user);
        }

        return "redirect:/cart.do?operate=setCart&userBean="+user.getId();
    }

    public String logOut(HttpSession session) {
        session.setAttribute("user",null);
        return "redirect:/book.do";
    }
}
