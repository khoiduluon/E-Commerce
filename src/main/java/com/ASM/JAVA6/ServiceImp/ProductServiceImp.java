package com.ASM.JAVA6.ServiceImp;

import java.util.List;

import com.ASM.JAVA6.DAO.ProductsDAO;
import com.ASM.JAVA6.Model.Products;
import com.ASM.JAVA6.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductsDAO productDAO;

    @Override
    public List<Products> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Products findById(int id) {
        return productDAO.findById(id).get();
    }

    @Override
    public List<Products> findByCategoryId(Integer cid) {
        return productDAO.findByCategoryId(cid);
    }

    @Override
    public Products create(Products product) {
        return productDAO.save(product);
    }

    @Override
    public Products update(Products product) {
        return productDAO.save(product);
    }

    @Override
    public void delete(Integer id) {
         productDAO.deleteById(id);
    }
    
}
