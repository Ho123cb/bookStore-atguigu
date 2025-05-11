package com.bookStore.dao.Impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.bookStore.dao.UserDAO;
import com.bookStore.pojo.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User getUserByIdAndpwdDAO(Integer id, String pwd) {
        return super.load("select * from t_user where id like ? AND pwd like ?");
    }
}
