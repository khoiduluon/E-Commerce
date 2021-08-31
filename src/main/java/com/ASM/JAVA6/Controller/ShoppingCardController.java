package com.ASM.JAVA6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCardController {
    @RequestMapping("/cart/view")
    public String list(){
        return "cart/view";
    }
}
