package com.kelelas.spring_security_example.controller;

import com.kelelas.spring_security_example.entity.RoleType;
import com.kelelas.spring_security_example.entity.UserLogin;
import com.kelelas.spring_security_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String mainPage(){
        return "main.html";
    }
    @RequestMapping("/all_user")
    public String usersPage(){
        if (role().equals(RoleType.ROLE_ADMIN))
        return "all_users.html";
        else
            return "all_user_error.html";
    }
    @RequestMapping("/form")
    public String regForm(){
        return "reg_form.html";
    }

    public RoleType role(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       UserLogin user = (UserLogin) authentication.getPrincipal();
       return user.getRole();
    }
}
