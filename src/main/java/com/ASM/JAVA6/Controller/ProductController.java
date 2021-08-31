package com.ASM.JAVA6.Controller;

import java.util.List;
import java.util.Optional;

import com.ASM.JAVA6.Model.Products;
import com.ASM.JAVA6.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    
    @RequestMapping("/product/list")
    public String list(Model model,@RequestParam("cid") Optional<Integer> cid){
        if(cid.isPresent()){
            List<Products> listProducts = productService.findByCategoryId(cid.get());
            model.addAttribute("items", listProducts);
        } else {
            List<Products> listProducts = productService.findAll();
        model.addAttribute("items", listProducts);
        }
        return "product/list";
    }

    @RequestMapping("/product/detail/{id}")
    public String detail(Model model,@PathVariable("id") int id){
        Products product = productService.findById(id);
        
           List<Products> p = product.getCategory().getProducts();
        for(Products l : p){
            System.out.println(l.getName());
        }
        model.addAttribute("product", product);
        return "product/detail";
    }
}
