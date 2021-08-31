package com.ASM.JAVA6.ServiceImp;

import java.util.List;

import com.ASM.JAVA6.DAO.CategoriesDAO;
import com.ASM.JAVA6.Model.Categories;
import com.ASM.JAVA6.Service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    CategoriesDAO categoriesDAO;

    @Override
    public List<Categories> findAll() {
        return categoriesDAO.findAll();
    }
}
