package com.bookStore.pojo;

import com.bookStore.util.DoubleUtils;

public class CartItem {
    private Integer id;
    private Book book;
    private Integer buyCount;
    private  User userBean;
    private Double xj;

    public Double getXj() {
        xj = (DoubleUtils.operationNum(buyCount.doubleValue(),book.getPrice().doubleValue(), "mul"));
        return xj;
    }

    public void setXj(Double xj) {
        this.xj = xj;
    }

    public CartItem() {
    }

    public CartItem(Integer id, Book book, Integer buyCount, User userBean) {
        this.id = id;
        this.book = book;
        this.buyCount = buyCount;
        this.userBean = userBean;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }
}
