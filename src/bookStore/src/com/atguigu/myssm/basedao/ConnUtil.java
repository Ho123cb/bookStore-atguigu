package com.atguigu.myssm.basedao;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnUtil {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    //private static ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();
    //private static ThreadLocal<Object> threadLocal3 = new ThreadLocal<>();

    public static  String DRIVER;
    public static  String URL;
    public static  String USER;
    public static  String PWD ;

    /**
     * 自动记载，读取配置文件jdbc中的信息内容
     */
    static {
        InputStream is = new BufferedInputStream(ConnUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        Properties properties = new Properties();
        try {
            properties.load(is);
            DRIVER = properties.getProperty("driverClassName");
            URL = properties.getProperty("url");
            USER = properties.getProperty("username");
            PWD = properties.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static Connection createConn(){
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null ;
    }

    public static Connection getConn(){
        Connection conn = threadLocal.get();
        if(conn==null){
            conn =createConn();
            threadLocal.set(conn);
        }
        return threadLocal.get() ;
    }

    public static void closeConn() throws SQLException {
        Connection conn = threadLocal.get();
        if(conn==null){
            return ;
        }
        if(!conn.isClosed()){
            conn.close();
            //threadLocal.set(null);
            threadLocal.remove();
        }
    }
}
