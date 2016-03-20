/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

//import uuu.totalbuy.domain.VIP;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.totalbuy.domain.TotalBuyException;


/**
 *
 * @author PattyTai
 */
public class TestVIP {
    public static void main(String[] args) {
        try {
            uuu.totalbuy.domain.VIP v =
                    new uuu.totalbuy.domain.VIP();
            v.setId("A223456781");
            System.out.println("v.getId(): " + v.getId());
            
            System.out.println("v.getDiscount(): " + v.getDiscount() + "%");
            System.out.println(v);
        } catch (TotalBuyException ex) {
            Logger.getLogger(TestVIP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
