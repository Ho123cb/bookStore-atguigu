package com.bookStore.controller;

import com.bookStore.pojo.User;
import com.bookStore.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
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

    public String logOut(HttpSession session, HttpServletResponse response) {
        session.setAttribute("user",null);
        Cookie cName = new Cookie("uname","");
        Cookie cPwd = new Cookie("pwd", "");
        cPwd.setMaxAge(0);
        cName.setMaxAge(0);
        response.addCookie(cName);
        response.addCookie(cPwd);
        return "redirect:/book.do";
    }

    public String registUser(String uname, String pwd, String email, String verifyCode, HttpSession session){
        if(!verifyCode.equals(session.getAttribute("KAPTCHA_SESSION_KEY")))
            return "user/regist";
        User user = new User(uname,pwd,email);
        System.out.println("path:userController");
        userService.addUser(user);
        return "user/login";
    }
    public String ckUname(String uname) {
        //书写业务方法，判断数据库有没有重名
        return userService.verifyUname(uname) == true? "json:{'uname':'1'}":"json:{'uname':'0'}";
    }
}
