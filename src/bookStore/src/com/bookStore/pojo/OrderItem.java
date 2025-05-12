package com.bookStore.pojo;

public class OrderItem {
    Integer id;
    Book book;
    Integer buyCount;
    Order orderBean;

    public Integer getId() {
        return id;
    }

    public OrderItem() {
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

    public Order getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(Order orderBean) {
        this.orderBean = orderBean;
    }
}
