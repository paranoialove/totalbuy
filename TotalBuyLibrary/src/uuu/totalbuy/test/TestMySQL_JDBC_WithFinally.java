/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;
import uuu.totalbuy.domain.Customer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PattyTai
 */
public class TestMySQL_JDBC_WithFinally {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/totalbuy?zeroDateTimeBehavior=convertToNull";
    private static final String userid = "root";
    private static final String password = "1234";
    
    public static void main(String[] args) {
        try {
            //1. 載入JDBC Driver類別定義
            Class.forName(driver);            
            Connection c = null;
            try {
                //2. 建立連線
                c = DriverManager.getConnection(url, userid, password);
                System.out.println(c.getCatalog());
                
                
                
                                  
            } catch (SQLException ex) {
                Logger.getLogger(TestMySQL_JDBC_WithFinally.class.getName()).log(Level.SEVERE, "無法建立連線", ex);
            }finally{
                //1. 關閉resultset
                //2. 關閉statement                
                try {
                    //3. connection
                    if(c!=null && !c.isClosed()){
                        c.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(TestMySQL_JDBC_WithFinally.class.getName()).log(Level.SEVERE, "無法關閉連線", ex);
                }
                  
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestMySQL_JDBC_WithFinally.class.getName()).log(Level.SEVERE, "無法載入JDBC Driver:" + driver, ex);
        }
    }
}
