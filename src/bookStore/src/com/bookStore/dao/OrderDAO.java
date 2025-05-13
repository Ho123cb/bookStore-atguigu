package com.bookStore.dao;

import java.time.LocalDateTime;

public interface OrderDAO {
    public int addOrderRetrunId(String orderNo, LocalDateTime orderDate, Integer orderUser, Double orderMoney);
    public void addOrderItem(Integer book,  Integer buyCount, Integer orderBean);
}
