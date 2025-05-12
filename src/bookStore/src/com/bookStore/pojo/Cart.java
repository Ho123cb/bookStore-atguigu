package com.bookStore.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    //图书的种类数量
    private Integer cartCount;
    //根据书的id进行存放的购物车
    private HashMap<Integer , CartItem> carts;
    private Integer books;
    private Double saleCount;

    public Double getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Double saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getBooks() {
        return books;
    }

    public void setBooks(Integer books) {
        this.books = books;
    }

    public Cart(){};

    public Cart(Integer cartCount, HashMap<Integer, CartItem> carts, Integer books, Double saleCount) {
        this.cartCount = cartCount;
        this.carts = carts;
        this.books = books;
        this.saleCount = saleCount;
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
