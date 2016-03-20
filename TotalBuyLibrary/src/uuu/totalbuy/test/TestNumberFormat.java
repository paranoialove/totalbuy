/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import java.text.NumberFormat;

/**
 *
 * @author PattyTai
 */
public class TestNumberFormat {
    public static void main(String[] args) {
        double k = 156.253995177777777777;
        System.out.println(Math.round(k));
        
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMinimumFractionDigits(3);
        nf.setMaximumFractionDigits(5);
        System.out.println(k);
        System.out.println(nf.format(k));
    }
}
