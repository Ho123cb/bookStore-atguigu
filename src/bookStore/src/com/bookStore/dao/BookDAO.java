package com.bookStore.dao;

import com.bookStore.pojo.Book;

import java.util.List;

public interface BookDAO {
    public List<Book> getBookList();
    public Book getbookByidDAO(Integer id);
}
