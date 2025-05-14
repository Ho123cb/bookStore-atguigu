package com.bookStore.controller;

import com.bookStore.pojo.Cart;
import com.bookStore.pojo.CartItem;
import com.bookStore.pojo.User;
import com.bookStore.service.CartService;
import com.bookStore.util.DoubleUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

public class CartController {

    CartService cartService;
    public String addCart(Integer book, HttpSession session) {
        Object userObj= session.getAttribute("user");
        User user = (User) userObj;
        Integer beanUser = user.getId();
       //根据id将书籍加入到表t_cart_item
        cartService.addCartSerivce(book, beanUser);
        setCart(beanUser,session);
        return "index";
    }

    public String setCart(Integer userBean, HttpSession session) {
        //根据userBean查询出所有的相关的cartitem并存到变量cart进入
        HashMap<Integer, CartItem> cartItemHashMap = cartService.getCartItems(userBean);
//        session.setAttribute("cart",new Cart(cartItemHashMap.size(),cartItemHashMap));
        User user =(User) session.getAttribute("user");
        int books = 0;
        Double saleCount = 0.0;
        for(var t : cartItemHashMap.entrySet()) {
            CartItem value = t.getValue();
            books += value.getBuyCount();
            saleCount += value.getBuyCount() * value.getBook().getPrice();
        }
        //精确实现位数进行约
        saleCount = DoubleUtils.reserveNumDigits(saleCount,1);
        user.setCart(new Cart(cartItemHashMap.size(),cartItemHashMap, books, saleCount));

        session.setAttribute("user",user);
        return "index";
    }

    public String editCart(Integer id, Integer oop, HttpSession session) {
        cartService.modifyCartItemByIdService(id,oop == 1);
        setCart(((User)session.getAttribute("user")).getId(),session);
        return "cart/cart";
    }
}
