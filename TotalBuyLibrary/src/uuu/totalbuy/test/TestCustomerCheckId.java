package uuu.totalbuy.test;


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
public class TestCustomerCheckId {
    public static void main(String[] args) {
        Customer c; 
        try {
            c = new Customer("A123456789", "John", "123456");       
            c.setId("A123456789");
            System.out.println(c.checkId("A123456789"));
        }catch(TotalBuyException ex){
            System.err.println(ex);
        }
        
        
    }
}
