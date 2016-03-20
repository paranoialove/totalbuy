/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.Outlet;
import uuu.totalbuy.domain.Product;
import uuu.totalbuy.domain.TotalBuyException;
import uuu.totalbuy.domain.VIP;
import uuu.totalbuy.model.OrderService;

/**
 *
 * @author PattyTai
 */
public class TestOrderService {
    public static void main(String[] args) {
        try {
            Customer c = new Customer("A123456789", "張三", "123456");
            Product p = new Product(1, "Apple iPhone 6S plus 16GB", 25500);
            
            VIP v = new VIP("A223456781", "林梅莉", "123456");
            
            Outlet o = new Outlet();
            o.setId(2);
            o.setName("Apple iPhone 4S 16GB");
            o.setUnitPrice(21800);
            o.setDiscount(50);
            
            OrderService service = new OrderService();
            System.out.println(service.order(c, p, 2)); //51000
            
            System.out.println(service.order(c, o, 1)); //10900, polymorphic argument: o
            System.out.println(service.order(v, p, 2)); //51000*.95 , polymorphic argument: v
            System.out.println(service.order(v, o, 1)); //10900, polymorphic arguments: v, o
            System.out.println(c);
        } catch (TotalBuyException ex) {
            Logger.getLogger(TestOrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
