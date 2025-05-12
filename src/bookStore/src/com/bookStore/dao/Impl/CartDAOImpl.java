package com.bookStore.dao.Impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.bookStore.dao.CartDAO;
import com.bookStore.pojo.CartItem;

import java.util.List;

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
    public List<CartItem> getListByUserBeanDAO(Integer userBean) {
        return super.executeQuery("select * from t_cart_item where userBean = ?", userBean);
    }
}
