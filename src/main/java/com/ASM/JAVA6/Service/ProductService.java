package com.ASM.JAVA6.Service;

import java.util.List;

import com.ASM.JAVA6.Model.Products;

public interface ProductService {

    List<Products> findAll();

    Products findById(int id);

    List<Products> findByCategoryId(Integer cid);

    Products create(Products product);

    Products update(Products product);

    void delete(Integer id);
    
}
