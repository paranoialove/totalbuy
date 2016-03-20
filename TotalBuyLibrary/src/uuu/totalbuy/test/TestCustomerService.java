/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.TotalBuyException;
import uuu.totalbuy.model.CustomerService;

/**
 *
 * @author PattyTai
 */
public class TestCustomerService {
    public static void main(String[] args) {
        try {
            CustomerService service =
                    new CustomerService();
            
            Customer c = service.get("A123456789");
            System.out.println(c);
            
//            Customer c2 = service.login("   ", "   ");
//            System.out.println(c2);
            
            List<Customer> list = service.getAll();
            System.out.println("查詢全部得到: "+ list);
                    
            
        } catch (TotalBuyException ex) {
            Logger.getLogger(TestCustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
