package com.bookStore.service.Impl;

import com.bookStore.dao.BookDAO;
import com.bookStore.pojo.Book;
import com.bookStore.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDAO bookDAO;
    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }
}
