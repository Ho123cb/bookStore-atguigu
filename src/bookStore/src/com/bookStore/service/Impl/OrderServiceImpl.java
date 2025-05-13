package com.bookStore.service.Impl;

import com.bookStore.dao.CartDAO;
import com.bookStore.dao.OrderDAO;
import com.bookStore.pojo.Book;
import com.bookStore.pojo.CartItem;
import com.bookStore.pojo.User;
import com.bookStore.service.OrderService;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    OrderDAO orderDAO;
    CartDAO cartDAO;
    @Override
    public int addOrderReIdService(HttpSession session) {
        //给予cart
        User user = (User) session.getAttribute("user");
        Integer orderUser = user.getId();
        LocalDateTime orderDate = LocalDateTime.now();
        Double orderMoney = user.getCart().getSaleCount();
        //获取orderNo
        String orderNo = UUID.randomUUID().toString();
        session.setAttribute("orderNo",orderNo);
        return  orderDAO.addOrderRetrunId(orderNo,orderDate,orderUser,orderMoney);
    }

    @Override
    public void addOrderItemByOrederBean(Integer orderBean, HttpSession session) {
        //依次取出book，buyCount,orderBean进行插入
        User user = (User) session.getAttribute("user");
        HashMap<Integer,CartItem> userCart = user.getCart().getCarts();
        for(Map.Entry<Integer, CartItem> orderItem : userCart.entrySet()) {
            Integer book = orderItem.getValue().getBook().getId();
            Integer buyCount = orderItem.getValue().getBuyCount();
            orderDAO.addOrderItem(book, buyCount, orderBean);
        }
    }

    /**
     * 业务层实现结账功能
     * @param session
     */
    public void checkOutService(HttpSession session) {
        int orderBean = addOrderReIdService(session);
        addOrderItemByOrederBean(orderBean, session);
        cartDAO.delCartItemByUserBeanDAO(((User)session.getAttribute("user")).getId());
    }
}
