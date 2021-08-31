package com.ASM.JAVA6.DAO;



import com.ASM.JAVA6.Model.Categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesDAO  extends JpaRepository<Categories, Integer>{
    
}
