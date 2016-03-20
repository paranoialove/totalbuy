/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import java.util.Date;

/**
 *
 * @author PattyTai
 */
public class TestDate {
    public static void main(String[] args) {
        System.out.println(new Date().after(new Date(1)));
        Date theDate = new Date(0);
        System.out.println(theDate);
        
        System.out.println(new Date(1000).after(null));
        
    }
}
