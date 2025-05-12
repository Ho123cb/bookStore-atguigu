package com.bookStore.controller;

import com.bookStore.pojo.Cart;
import com.bookStore.pojo.CartItem;
import com.bookStore.pojo.User;
import com.bookStore.service.CartService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class CartController {

    CartService cartService;
    public String addCart(Integer book, HttpSession session) {
        Object userObj= session.getAttribute("user");
        User user = (User) userObj;
        Integer beanUser = user.getId();
       //根据id将书籍加入到表t_cart_item
        cartService.addCartSerivce(book, beanUser);
        return "index";
    }

//    public String setCart(Integer userBean, HttpSession session) {
//        //根据userBean查询出所有的相关的cartitem并存到变量cart进入
//        List<CartItem> cartItemList = cartService.getListByUserBean(userBean);
//
//    }
}
