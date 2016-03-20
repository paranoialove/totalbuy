package uuu.totalbuy.test;

import uuu.totalbuy.domain.Outlet;
import uuu.totalbuy.domain.Product;
public class TestProductClone {
    public static void main(String[] args) {
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("mouse");
        p1.setUnitPrice(100);
        
        Product p2 = new Product(p1.getId(), p1.getName(), p1.getUnitPrice()); //p1.clone();
        
        System.out.println(p1!=p2); //true
        System.out.println(p1.getClass() == p2.getClass()); //true
        System.out.println(p1.equals(p2)); //true, 因為已經override equals()方法
        
        Outlet o1 = new Outlet();
        o1.setId(1);
        o1.setName("mouse");
        o1.setUnitPrice(100);
        
        System.out.println(p1.equals(o1));
        
    }
}
