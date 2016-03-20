package uuu.totalbuy.test;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.TotalBuyException;
import uuu.totalbuy.domain.VIP;

public class TestPolymorphism {
    public static void main(String[] args) {
        try {
            Object o = "Hello"; //polymorphism, upward casting
            System.out.println(o.getClass().getName());
            System.out.println(o.toString());
            //System.out.println(o.length());
            
            //String s = "Hello"; //一般宣告
            if(o instanceof String){
                String s = (String)o; //downward casting
                System.out.println(s.toString());
                System.out.println(s.length());
            }
            
            o = new Date();//polymorphism
            System.out.println(o.getClass().getName());
            
            o = new Customer("A123456789", "John", "123456");
            System.out.println(o.getClass().getName());
            
            Customer c = new VIP("A223456781", "Mary", "123456");
            System.out.println(c.getId());
            //System.out.println(c.getDiscount());
            System.out.println(c.toString());
        } catch (TotalBuyException ex) {
            Logger.getLogger(TestPolymorphism.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
