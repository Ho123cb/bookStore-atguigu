package com.bookStore.service;

import com.bookStore.pojo.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderService {
    public int addOrderReIdService(HttpSession session);
    public void addOrderItemByOrederBean(Integer orderBean, HttpSession session);
    public void checkOutService(HttpSession session);
    public List<Order> getOrderIdList(Integer orderUser);
}
