/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.VIP;

/**
 *
 * @author PattyTai
 */
public class TestInstanceof {
    public static void main(String[] args) {
        Object o = new Object();
        String s = "Hello";
        Customer c = new Customer();
        VIP v = new VIP();
        
        
        System.out.println(o instanceof Object);//true
        System.out.println(o instanceof String);//false
        System.out.println(o instanceof Customer); //false
        System.out.println(o instanceof VIP);//false

        System.out.println(s instanceof Object);//true
        System.out.println(s instanceof String);//true
        //System.out.println(s instanceof Customer); //compile-time error
        //System.out.println(s instanceof VIP);//compile-time error

        
        System.out.println(c instanceof Object);//true
        //System.out.println(c instanceof String); //compile-time error
        System.out.println(c instanceof Customer); //true
        System.out.println(c instanceof VIP);//false
        
        System.out.println(v instanceof Object);//true
        //System.out.println(v instanceof String); //compile-time error
        System.out.println(v instanceof Customer);//true
        System.out.println(v instanceof VIP);//true
        
        o = null;
        System.out.println(o instanceof Object);//false
        System.out.println(o instanceof String);//false
        System.out.println(o instanceof Customer); //false
        System.out.println(o instanceof VIP);//false
        
    }
}
