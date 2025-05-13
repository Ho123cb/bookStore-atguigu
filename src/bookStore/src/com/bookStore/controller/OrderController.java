package com.bookStore.controller;

import com.bookStore.pojo.Order;
import com.bookStore.pojo.User;
import com.bookStore.service.OrderService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderController {
    OrderService orderService;
    public String index(HttpSession session) {
        orderService.checkOutService(session);
        return "cart/checkout";
    }

    public String showOrder( Integer orderUser, HttpSession session) {
        List<Order> orderIdList = orderService.getOrderIdList(orderUser);
        User user = (User) session.getAttribute("user");
        user.setOrderList(orderIdList);
        session.setAttribute("user",user);
        return "order/order";
    }
}
