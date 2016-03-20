/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.model;

import java.sql.*;
import java.util.ResourceBundle;
import uuu.totalbuy.domain.TotalBuyException;

/**
 *
 * @author PattyTai
 */
public class RDBConnection {

    private static final String driver;
    private static final String url;
    private static final String userid;
    private static final String password;

    //靜態初始化 static initializer
    static {
        //預先讀取設定檔 使用完整檔名
        ResourceBundle bundle = ResourceBundle.getBundle("uuu.totalbuy.model.JDBCSettings");
        String dr = bundle.getString("jdbc.driver");
        if (dr != null) {
            driver = dr;
        } else {
            driver = "com.mysql.jdbc.Driver";
        }

        String ur = bundle.getString("jdbc.url");
        if (ur != null) {
            url = ur;
        } else {
            url = "jdbc:mysql://localhost:3306/totalbuy?zeroDateTimeBehavior=convertToNull";
        }

        String id = bundle.getString("jdbc.userid");
        if (id != null) {
            userid = id;
        } else {
            userid = "root";
        }

        String ps = bundle.getString("jdbc.password");
        if (ps != null) {
            password = ps;
        } else {
            password = "123456789";
        }
    }

    public static Connection getConnection() throws TotalBuyException {
        Connection c = null;
        try {
            //1. load JDBC Driver
            Class.forName(driver);

            //2. 建立連線
            try {
                c = DriverManager.getConnection(url, userid, password);
                return c;
            } catch (SQLException ex) {
                System.out.println("無法建立連線");
                throw new TotalBuyException("無法建立MySQL JDBC連線", ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("無法載入Driver: " + driver);
            throw new TotalBuyException("無法載入Driver: " + driver, ex);
        }
    }
}
