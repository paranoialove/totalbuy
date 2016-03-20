/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import uuu.totalbuy.domain.BloodType;
import uuu.totalbuy.domain.Customer;

/**
 *
 * @author PattyTai
 */
public class TestCustomerBloodType {
    public static void main(String[] args) {
        
        
        Customer c = new Customer();
        c.setBloodType(BloodType.AB);
        
        System.out.println(c.getBloodType()); //AB
        System.out.println(c.getBloodType().getCode()); //AB
        
        //System.out.println(BloodType.values());
    }
}
