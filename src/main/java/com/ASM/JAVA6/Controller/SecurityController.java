package com.ASM.JAVA6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    
    @RequestMapping("security/login/form")
    public String loginForm(Model model){
        model.addAttribute("message", "Đăng nhập đê");
        return "security/login";
    }

    @RequestMapping("security/login/success")
    public String loginSucess(Model model){
        model.addAttribute("message", "Đăng nhập Ok");
        return "security/login";
    }

    
    @RequestMapping("security/login/error")
    public String loginError(Model model){
        model.addAttribute("message", "Sai thông tin đăng nhập");
        return "security/login";
    }

    @RequestMapping("security/unauthoried")
    public String unauthoried(Model model){
        model.addAttribute("message", "Không có quyền truy xuất");
        return "security/login";
    }

    @RequestMapping("security/logoff/success")
    public String logoffSucess(Model model){
        model.addAttribute("message", "Đã đăng xuất");
        return "security/login";
    }
}
