package com.bookStore.dao.Impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.bookStore.dao.BookDAO;
import com.bookStore.pojo.Book;

import java.util.List;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return super.executeQuery("select * from t_book");
    }
}
