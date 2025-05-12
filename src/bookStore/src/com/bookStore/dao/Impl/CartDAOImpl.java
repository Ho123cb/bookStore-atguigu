package com.bookStore.dao.Impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.bookStore.dao.CartDAO;
import com.bookStore.pojo.CartItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CartDAOImpl extends BaseDAO<CartItem> implements CartDAO {

    @Override
    public void insertCartDAO(Integer book, Integer userBean) {
        super.executeUpdate("insert into t_cart_item values(0,?,1,?)",book,userBean);
    }

    @Override
    public void updateCartDAO(Integer book) {
        super.executeUpdate("update t_cart_item set buyCount = buyCount + 1 where book = ?", book);
    }

    @Override
    public boolean bookInCartDAO(Integer book) {
        return !super.executeQuery("select * from t_cart_item where book = ? ", book).isEmpty();
    }

    @Override
    public List<Integer> getBookIdByUserBean(Integer userBean) {
        List<CartItem> cartItemList = super.executeQuery("select book from t_cart_item where userBean = ?", userBean);
        List<Integer> list = cartItemList.stream().map(t -> t.getBook().getId()).toList();
        return list;
    }

    @Override
    public CartItem getCartItemByBook(Integer book, Integer userBean) {
        return super.load("select * from t_cart_item where book = ? AND userBean = ?",book, userBean);
    }

}
