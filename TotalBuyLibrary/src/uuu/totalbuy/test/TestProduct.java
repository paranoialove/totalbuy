/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import uuu.totalbuy.domain.Product;
import uuu.totalbuy.model.ProductService;

/**
 *
 * @author PattyTai
 */
public class TestProduct {
    public static void main(String[] args) {
        Product p = new Product();
        p.setId(1);
        p.setName("Mouse");
        p.setUnitPrice(100);
        System.out.println("p.getUnitPrice() = " + p.getUnitPrice()); //100
        //.....
        
//        double price = p.getUnitPrice() + 10;
//        p.setUnitPrice(price);

        ProductService service = new ProductService();
        service.addPrice(p.getUnitPrice());                
        System.out.println("p.getUnitPrice() = " + p.getUnitPrice());//100
        
        service.addPrice(p);
        System.out.println("p.getUnitPrice() = " + p.getUnitPrice());//110
        System.out.println(p);
    }
}
