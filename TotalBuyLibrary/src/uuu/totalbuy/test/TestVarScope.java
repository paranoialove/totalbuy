package uuu.totalbuy.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class TestVarScope {
    private int i;//attribute, field, member variable    
    
    public static void main(String[] args) {
        int i;
        //i=1; //local variable
        System.out.println(i=1);
    }
}
