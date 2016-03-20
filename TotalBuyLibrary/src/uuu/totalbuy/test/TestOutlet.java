/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import uuu.totalbuy.domain.Outlet;
import uuu.totalbuy.domain.Product;

/**
 *
 * @author PattyTai
 */
public class TestOutlet {
    public static void main(String[] args) {
        Outlet o = new Outlet();
        
        o.setId(2);
        o.setName("Apple iPhone 4S 16GB");
        o.setUnitPrice(16500);
        System.out.println("名稱:"+o.getName());
 //       System.out.println("折扣:"+o.getDiscount());
        System.out.println("售價:"+o.getUnitPrice());
        System.out.println("原價:"+o.getListPrice());
        
        System.out.println(o);
        System.out.println(o.toString());
        //System.out.println("Hello".toString());
    }
}
