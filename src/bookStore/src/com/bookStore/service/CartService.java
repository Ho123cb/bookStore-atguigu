package com.bookStore.service;

import com.bookStore.pojo.CartItem;

import java.util.List;

public interface CartService {
    public void addCartSerivce(Integer id, Integer userBean);
    public List<CartItem>  getListByUserBean(Integer userBean);
}
