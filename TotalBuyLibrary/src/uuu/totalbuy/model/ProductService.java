/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.model;

import java.util.List;
import uuu.totalbuy.domain.Product;
import uuu.totalbuy.domain.TotalBuyException;

/**
 *
 * @author Administrator
 */
public class ProductService {
    private RDBProductsDAO dao = new RDBProductsDAO();
    
    

    public void insert(Product data) throws TotalBuyException {
        dao.insert(data);
    }

    public void update(Product data) throws TotalBuyException {
        dao.update(data);
    }

    public void delete(Product data) throws TotalBuyException {
        dao.delete(data);
    }

    public Product get(Integer key) throws TotalBuyException {
        return dao.get(key);
    }

    public List<Product> getAll() throws TotalBuyException {
        return dao.getAll();
    }

    public List<Product> getByName(String data) throws TotalBuyException {
        return dao.getByName(data);
    }

    public void addPrice(double unitPrice) {
        unitPrice = unitPrice +10;
    }

    public void addPrice(Product p) {
        p.setUnitPrice(p.getUnitPrice()+10);
    }
}
