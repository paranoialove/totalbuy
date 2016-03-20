/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.TotalBuyException;

/**
 *
 * @author PattyTai
 */
public class TestFinalCustomer {
    public static void main(String[] args) {
        try {
            final Customer c = new Customer("A123456789", "John", "123456");
            System.out.println("c.getId() = " + c.getId());
            
            c.setId("A123456770");
            System.out.println("c.getId() = " + c.getId());
        } catch (TotalBuyException ex) {
            Logger.getLogger(TestFinalCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
