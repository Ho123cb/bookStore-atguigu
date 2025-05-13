package com.bookStore.service;

import javax.servlet.http.HttpSession;

public interface OrderService {
    public int addOrderReIdService(HttpSession session);
    public void addOrderItemByOrederBean(Integer orderBean, HttpSession session);
    public void checkOutService(HttpSession session);
}
