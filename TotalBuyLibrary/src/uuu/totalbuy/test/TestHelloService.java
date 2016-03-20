package uuu.totalbuy.test;


import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.totalbuy.model.HelloService;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.TotalBuyException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class TestHelloService {
    public static void main(String[] args) {
        try {
            HelloService service = new HelloService();
            
            System.out.println(service.sayHello());
            
            String rtn = service.sayHello("Peter");
            System.out.println(rtn);//哈囉, Peter
            
            Customer c = new Customer();
            c.setName("John");
            String rtn2 = service.sayHello(c);
            System.out.println(rtn2);//哈囉, John
            
            System.out.println(Math.random());
            
            int len = service.sayHello().length();
            System.out.println(len);
            
            
            String s = null;
            System.out.println(s);
            
            //System.out.println(null);//編譯失敗, ambiguous
        } catch (TotalBuyException ex) {
            Logger.getLogger(TestHelloService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
