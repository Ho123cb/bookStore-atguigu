package com.bookStore.dao;

import com.bookStore.pojo.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderDAO {
    public int addOrderRetrunId(String orderNo, LocalDateTime orderDate, Integer orderUser, Double orderMoney);
    public void addOrderItem(Integer book,  Integer buyCount, Integer orderBean);
    public List<Order> getorderIdListDAO(Integer orderUser);
}
