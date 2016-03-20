/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import uuu.totalbuy.domain.Product;

/**
 *
 * @author PattyTai
 */
public class TestEqualsOperator {
    public static void main(String[] args) {
        Product p1 = new Product(1, "mouse", 200);
        Product p2 = new Product(1, "mouse", 200);
        System.out.println(p1==p2); //false
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p2)?p1.hashCode()==p2.hashCode():false);
    }
}
