package com.bookStore.service.Impl;

import com.bookStore.dao.CartDAO;
import com.bookStore.pojo.CartItem;
import com.bookStore.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDAO cartDAO;
    @Override
    public void addCartSerivce(Integer book, Integer userBean) {
        boolean updateORinsert = cartDAO.bookInCartDAO(book);
        if(updateORinsert) {
            cartDAO.updateCartDAO(book);
        }
        else {
            cartDAO.insertCartDAO(book,userBean);
        }
    }

    @Override
    public List<CartItem> getListByUserBean(Integer userBean) {
        return cartDAO.getListByUserBeanDAO(userBean);
    }
}
