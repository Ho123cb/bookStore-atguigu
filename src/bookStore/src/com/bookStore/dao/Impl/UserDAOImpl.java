package com.bookStore.dao.Impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.bookStore.dao.UserDAO;
import com.bookStore.pojo.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User getUserByIdAndpwdDAO(String uname, String pwd) {
        return super.load("select * from t_user where uname like ? AND pwd like ?", uname,pwd);
    }

    @Override
    public void addUser(User user) {
        super.executeUpdate("insert into t_user values(0,?,?,?,0)",user.getUname(),user.getPwd(),user.getEmail());
    }

    @Override
    public String getUserName(String uname) {
        return (String)super.executeComplexQuery("select uname from t_user where uname like ?", uname)[0];
    }
}
