package com.bookStore.service;

import com.bookStore.pojo.Book;

import java.util.List;

public interface BookService {
    //获取对应的bookList
    public List<Book> getBookList();
}
