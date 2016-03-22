/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.model;

import java.util.List;
import uuu.totalbuy.domain.TotalBuyException;

/**
 *
 * @author Administrator
 */
public interface DAOInterface <K, T> {
    void insert(T data) throws TotalBuyException;
    void update(T data) throws TotalBuyException;
    void delete(T data) throws TotalBuyException;
    T get(K key)throws TotalBuyException;
    List<T> getAll()throws TotalBuyException;
}
