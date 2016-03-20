/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.model;

import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.Outlet;
import uuu.totalbuy.domain.Product;
import uuu.totalbuy.domain.VIP;

/**
 *
 * @author PattyTai
 */
public class OrderService {
//    public double order(Customer c, ShoppingCart cart){
//        
//    }

    public double order(Customer c, Product p,
            int quantity) {
        double rtn = 0;
        if (c != null && p != null && quantity > 0) {
            rtn = p.getUnitPrice() * quantity;
            if(!(p instanceof Outlet) && c instanceof VIP){
                //VIP v = (VIP)c;
                //rtn *= (100-v.getDiscount())/100D;
                rtn *= (100-((VIP)c).getDiscount())/100D;
            }
        }else{
            //拋出錯誤
        }
        return rtn;
    }
}
