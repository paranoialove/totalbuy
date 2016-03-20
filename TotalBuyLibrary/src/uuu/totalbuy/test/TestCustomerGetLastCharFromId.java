/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import uuu.totalbuy.domain.Customer;

/**
 *
 * @author PattyTai
 */
public class TestCustomerGetLastCharFromId {
    public static void main(String[] args) {
        System.out.println(Customer.getLastCharFromId("A12345678"));
        System.out.println(Customer.getLastCharFromId("A12345677"));
    }
}
