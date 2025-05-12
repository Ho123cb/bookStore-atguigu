package com.bookStore.dao;

import com.bookStore.pojo.CartItem;

import java.util.List;

public interface CartDAO {
    public void insertCartDAO(Integer book, Integer userBean);
    public void updateCartDAO(Integer book);
    public boolean bookInCartDAO(Integer book);
    public List<CartItem> getListByUserBeanDAO(Integer userBean);
}
