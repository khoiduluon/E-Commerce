package com.ASM.JAVA6.RestController;

import java.util.List;

import com.ASM.JAVA6.Model.Products;
import com.ASM.JAVA6.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    
    @Autowired
    ProductService productService;

    @GetMapping("{id}")
    public Products getOne(@PathVariable("id") Integer id){
        return productService.findById(id);
    }

    @GetMapping()
    public List<Products> getAll(){
        return productService.findAll();
    }

    @PostMapping
    public Products create(@RequestBody Products product){
        return productService.create(product);
    }

    @PutMapping("{id}")
    public Products update(@PathVariable("id") Integer id, @RequestBody Products product){
        return productService.update(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        productService.delete(id);
    }

}
