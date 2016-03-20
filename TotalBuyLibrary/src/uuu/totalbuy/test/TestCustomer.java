package uuu.totalbuy.test;

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TestCustomer {

    public static void main(String[] args) {
        try {
            int i = 1;
            Customer c = new Customer("A123456789", "  張三   ",
                    'M', "123456", "three.chang@gmail.com");

            //if(c.checkId("A123456789")){
            //c.setId("A123456789");
//        }else{
//            System.out.println("Id不正確");
//        }
//c.setName("       張三       ");
            c.setGender(Customer.MALE);
//c.setPassword("123456");
//        c.setEmail("three.chang@gmail.com");
            c.setBirthday("1999/9/9");
//        c.setPhone("25149191");
//        c.setAddress("台北市復興北路99號14F");
//        c.setMarried(false);
//        c.setStatus(0);

            System.out.println("c.id = " + c.getId());
            System.out.println("c.name = " + c.getName());
            System.out.println("c.gender = " + (c.getGender() == Customer.MALE ? "MALE" : "FEMALE"));
            System.out.println("c.password = " + c.getPassword());
            System.out.println("c.email = " + c.getEmail());
            System.out.println("c.birthday = " + c.getBirthday());
            System.out.println("c.phone = " + c.getPhone());
            System.out.println("c.married = " + c.isMarried());
            System.out.println("c.address = " + c.getAddress());
            System.out.println("c.status = " + c.getStatus());
            System.out.println("c.getAge() = " + c.getAge());
            System.out.println(c);
        } catch (TotalBuyException ex) {
            Logger.getLogger(TestCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
