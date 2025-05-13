package com.bookStore.dao.Impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.bookStore.dao.OrderDAO;
import com.bookStore.pojo.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDAOImpl extends BaseDAO<Order> implements OrderDAO {
    @Override
    public int addOrderRetrunId(String orderNo, LocalDateTime orderDate, Integer orderUser, Double orderMoney) {
        return super.executeUpdate("insert into t_order values(0,?,?,?,?,0)", orderNo, orderDate, orderUser, orderMoney);
    }

    @Override
    public void addOrderItem(Integer book, Integer buyCount, Integer orderBean) {
        super.executeUpdate("insert into t_order_item values(0,?,?,?)",book, buyCount, orderBean);
    }

    @Override
    public List<Order> getorderIdListDAO(Integer orderUser) {
        return super.executeQuery("select * from t_order where orderUser = ?", orderUser);
    }
}
