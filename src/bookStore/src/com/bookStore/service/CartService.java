package com.bookStore.service;

import com.bookStore.pojo.CartItem;

import java.util.HashMap;
import java.util.List;

public interface CartService {
    public void addCartSerivce(Integer id, Integer userBean);
    public HashMap<Integer, CartItem> getCartItems(Integer userBean);
    public void delCartItemByUserBean(Integer userBean);
    public void modifyCartItemByIdService(Integer id, boolean AddOrSub);
}
