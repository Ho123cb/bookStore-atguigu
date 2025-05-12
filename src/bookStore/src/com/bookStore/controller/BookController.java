package com.bookStore.controller;

import com.bookStore.pojo.Book;
import com.bookStore.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class BookController {
    BookService bookService;
    public String index(HttpSession session) {
        session.setAttribute("bookList", bookService.getBookList());
        return "index";
    }
}
