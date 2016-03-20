/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.domain;

/**
 *
 * @author PattyTai
 */
public class Outlet extends Product {

    private int discount = 30;

    public Outlet() {
    }

    public Outlet(int id, String name, double unitPrice) {
        super(id, name, unitPrice);
    }

    public Outlet(int id, String name, double unitPrice, boolean free, int stock) {
        super(id, name, unitPrice, free, stock);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public double getUnitPrice() {
        double rtn = super.getUnitPrice();
        rtn = rtn * (100 - this.discount) / 100;
        return rtn; //To change body of generated methods, choose Tools | Templates.
    }

    public double getListPrice() {
        return super.getUnitPrice();
    }

    @Override
    public String toString() {
        return "Outlet{" + super.toString() + ", discount=" + discount + '}';
    }

}
