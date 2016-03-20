package uuu.totalbuy.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.TotalBuyException;
public class TestCustomer2 {

    public static void main(String[] args) {
        try {
            int i = 1;
            int j = i;
            
            System.out.println(i == j);
            
            j = i + 1;
            System.out.println("i = " + i); //1
            System.out.println("j = " + j); //2
            System.out.println(i == j);
            Customer c1 = new Customer("A123456789", "張三", "123456");
            Customer c2 = new Customer("A123456789", c1.getName(), c1.getPassword());
            
            System.out.println("c1.getName() = " + c1.getName());//張三
            System.out.println("c2.getName() = " + c2.getName());//張三
            
            System.out.println(c1 == c2);
            c2.setName("張三豐");
            System.out.println("c1.getName() = " + c1.getName());//張三
            System.out.println("c2.getName() = " + c2.getName());//張三豐
            
            c2 = c1;
            System.out.println("c1.getName() = " + c1.getName());//張三
            System.out.println("c2.getName() = " + c2.getName());//張三
            System.out.println(c1 == c2);
            c2.setName("張三豐");
            System.out.println("c1.getName() = " + c1.getName());//張三豐        
            System.out.println("c2.getName() = " + c2.getName());//張三豐        
        } catch (TotalBuyException ex) {
            Logger.getLogger(TestCustomer2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
