package com.bookStore.dao.Impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.bookStore.dao.OrderItemDAO;
import com.bookStore.pojo.OrderItem;

import java.math.BigDecimal;

public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {

    @Override
    public Integer getOrderNumbers(Integer orderBean) {
        return ((BigDecimal) super.executeComplexQuery("select sum(buyCount) from t_order_item where orderBean = ?", orderBean)[0]).intValue();
    }
}
