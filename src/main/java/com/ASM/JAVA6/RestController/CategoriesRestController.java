package com.ASM.JAVA6.RestController;

import java.util.List;

import com.ASM.JAVA6.Model.Categories;
import com.ASM.JAVA6.Service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoriesRestController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public List<Categories> getAllI(){
        return categoryService.findAll();
    }
}
