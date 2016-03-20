/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import java.util.List;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.TotalBuyException;
import uuu.totalbuy.model.RDBCustomersDAO;

/**
 *
 * @author PattyTai
 */
public class TestRDBCustomerDAO {
    public static void main(String[] args) {
        try {
            RDBCustomersDAO dao = new RDBCustomersDAO();
            //test insert
            Customer c1 = new Customer();
            c1.setId("A123456752");
            c1.setName("陳五");
            c1.setGender(Customer.MALE);
            c1.setPassword("123456");
            c1.setEmail("chen.five@gmail.com");
            dao.insert(c1);
            
            //test get
            Customer c = dao.get("A123456752");
            System.out.println(c);
            
            c.setAddress("台北市復興南路2段15號");
            dao.update(c);
            
            //test getAll
            List<Customer> list = dao.getAll();
            System.out.println("查詢全部得到: "+ list);
            
            dao.delete(c);
            System.out.println("查詢全部得到: "+ list);
        } catch (TotalBuyException ex) {
            System.out.println("測試失敗:"+ ex);
            if(ex.getCause()!=null){
                System.out.println("原因: "+ex.getCause());
            }
        }
    }
}
