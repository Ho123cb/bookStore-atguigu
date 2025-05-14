package com.bookStore.service.Impl;

import com.bookStore.dao.CartDAO;
import com.bookStore.pojo.Book;
import com.bookStore.pojo.Cart;
import com.bookStore.pojo.CartItem;
import com.bookStore.pojo.User;
import com.bookStore.service.BookService;
import com.bookStore.service.CartService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public class CartServiceImpl implements CartService {
    CartDAO cartDAO;
    BookService bookService;
    @Override
    public void addCartSerivce(Integer book, Integer userBean) {
        boolean updateORinsert = cartDAO.bookInCartDAO(book, userBean);
        if(updateORinsert) {
            cartDAO.updateCartDAO(book, userBean);
        }
        else {
            cartDAO.insertCartDAO(book,userBean);
        }
    }


    @Override
    public HashMap<Integer, CartItem> getCartItems(Integer userBean) {
        //首先查出book(id)列表，再依次加入Id对应的cartItem
        List<Integer> idList = cartDAO.getBookIdByUserBean(userBean);
        HashMap<Integer, CartItem> cartItemHashMap = new HashMap<>(idList.size());
        for(int i = 0; i < idList.size(); i++) {
            int book = idList.get(i);
            //设计一个DAO使其返回cartItem对象根据
            CartItem cartItem = cartDAO.getCartItemByBook(book, userBean);
            //补充book字段的内容
            cartItem.setBook(bookService.getBookByid(book));
            cartItemHashMap.put( book, cartItem);
        }

        return cartItemHashMap;
    }

    @Override
    public void delCartItemByUserBean(Integer userBean) {
        cartDAO.delCartItemByUserBeanDAO(userBean);
    }

    @Override
    public void modifyCartItemByIdService(Integer id, boolean AddOrSub) {
        if(AddOrSub) {//add
            cartDAO.addCartItemDAO(id);
        }
        else {//sub
            cartDAO.subCartItemDAO(id);
        }
    }
}
