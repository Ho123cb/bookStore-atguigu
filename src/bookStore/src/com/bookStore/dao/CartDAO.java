package com.bookStore.dao;

import com.bookStore.pojo.CartItem;

import java.util.List;

public interface CartDAO {
    public void insertCartDAO(Integer book, Integer userBean);
    public void updateCartDAO(Integer book, Integer userBean);
    public boolean bookInCartDAO(Integer book, Integer userBean);
    public List<Integer> getBookIdByUserBean(Integer userBean);
    public CartItem getCartItemByBook(Integer book, Integer userBean);
    public void delCartItemByUserBeanDAO(Integer userBean);
    public void subCartItemDAO(Integer id);
    public void addCartItemDAO(Integer id);
}
