/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.model;

import java.util.List;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.TotalBuyException;

/**
 *
 * @author PattyTai
 */
public class CustomerService {
    private RDBCustomersDAO dao = new RDBCustomersDAO();

    public Customer login(String id, String pwd)throws TotalBuyException{
        if((id==null || ((id=id.trim()).length()==0)) || 
                ((pwd==null)|| ((pwd=pwd.trim()).length()==0))){
            throw new TotalBuyException("必須輸入帳號密碼!");
        }
        
        Customer c = dao.get(id);
        if(c!=null && pwd.equals(c.getPassword())){
            return c;
        }
        
        throw new TotalBuyException("帳號或密碼不正確，登入失敗!");
    }
    
    
    public void register(Customer c) throws TotalBuyException {
        dao.insert(c);
    }

    public void update(Customer c) throws TotalBuyException {
        dao.update(c);
    }

    public void delete(Customer c) throws TotalBuyException {
        dao.delete(c);
    }

    public Customer get(String id) throws TotalBuyException {
        return dao.get(id);
    }

    public List<Customer> getAll() throws TotalBuyException {
        return dao.getAll();
    }
}
