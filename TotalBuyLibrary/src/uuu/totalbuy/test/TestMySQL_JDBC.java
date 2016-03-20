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
import uuu.totalbuy.domain.BloodType;
import uuu.totalbuy.domain.TotalBuyException;
/**
 *
 * @author PattyTai
 */
public class TestMySQL_JDBC {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/totalbuy?zeroDateTimeBehavior=convertToNull";
    private static final String userid = "root";
    private static final String password = "1234";
    private static final String sql = 
            "SELECT id,name,gender,password,email,birthday,phone,address,married,blood_type,type,discount,status "
            + "FROM customers ";
            //+ "WHERE id = 'A223456781' AND password='123456'";
    
    public static void main(String[] args) {
        try {
            //1. 載入JDBC Driver類別定義
            Class.forName(driver);                       
            try (
                    Connection c = DriverManager.getConnection(url, userid, password);//2. 建立連線
                    Statement stmt = c.createStatement();//3. 建立指令物件
                    ResultSet rs = stmt.executeQuery(sql);//4. 執行指令
                ){
                System.out.println(c.getCatalog());
                //5.處理Resultset
                while(rs.next()){                    
                    try{
                        Customer cust = new Customer();
                        cust.setId(rs.getString("id"));
                        cust.setName(rs.getString("name"));
                        cust.setPassword(rs.getString("password"));
                        cust.setGender(rs.getString("gender").charAt(0));
                        cust.setEmail(rs.getString("email"));
                        cust.setBirthday(rs.getDate("birthday"));
                        cust.setPhone(rs.getString("phone"));
                        cust.setAddress(rs.getString("address"));
                        cust.setMarried(rs.getBoolean("married"));
                        
                        String bType = rs.getString("blood_type");
                        if(bType!=null && (bType=bType.trim()).length()>0){
                            cust.setBloodType(BloodType.valueOf(bType));
                        }
                        
                        System.out.println("cust:" + cust);                        
                    }catch(TotalBuyException ex){
                        System.out.println(ex);
                    }
                }                
                
                //c.close();                  
            } catch (SQLException ex) {
                Logger.getLogger(TestMySQL_JDBC.class.getName()).log(Level.SEVERE, "無法建立連線", ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestMySQL_JDBC.class.getName()).log(Level.SEVERE, "無法載入JDBC Driver:" + driver, ex);
        }
    }
}
