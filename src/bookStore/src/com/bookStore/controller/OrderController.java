package com.bookStore.controller;

import com.bookStore.service.OrderService;

import javax.servlet.http.HttpSession;

public class OrderController {
    OrderService orderService;
    public String index(HttpSession session) {
        orderService.checkOutService(session);
        return "cart/checkout";
    }
}
