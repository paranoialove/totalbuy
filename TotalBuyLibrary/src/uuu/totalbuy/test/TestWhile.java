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
public class TestWhile {

    public static void main(String[] args) {
//        for (int i=1;i<10;i++){
//            System.out.println("i = " + i);
//        }

        int i = 1;

        while (i < 10) {
            if (i == 3 || i == 8 || i == 9) {
                i++;
                continue;
            }
            System.out.println("i = " + i++);
        }

        do {
            System.out.println("i = " + i++);
        } while (i < 10);
    }
}
