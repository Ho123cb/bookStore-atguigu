package com.bookStore.pojo;

import java.util.HashMap;

public class Cart {
    private Integer cartCount;
    //根据书的id进行存放的购物车
    private HashMap<Integer , CartItem> carts;

    public Cart() {
    }

    public Cart(Integer cartCount, HashMap<Integer, CartItem> carts) {
        this.cartCount = cartCount;
        this.carts = carts;
    }

    public Integer getCartCount() {
        return cartCount;
    }

    public void setCartCount(Integer cartCount) {
        this.cartCount = cartCount;
    }

    public HashMap<Integer, CartItem> getCarts() {
        return carts;
    }

    public void setCarts(HashMap<Integer, CartItem> carts) {
        this.carts = carts;
    }
}
