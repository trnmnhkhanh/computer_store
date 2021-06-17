package nlu.vn.accomputer.controller;


import nlu.vn.accomputer.service.AccessoryService;
import nlu.vn.accomputer.service.CategoryService;
import nlu.vn.accomputer.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller("WebHome")
public class HomeController {

    @Autowired
    private AccessoryService accessoryService;
    private CategoryService categoryService;


    @GetMapping(value = {"/"} )
    public String showHome(Model model){
//        model.addAttribute("title","Home");
        return "user/index";
    }
    @GetMapping("/admin")
    public  String adminPage(Model model, Principal principal){
        User loginedUser = (User)  ((Authentication) principal).getPrincipal();
        String accountInfo = WebUtils.toString(loginedUser);
        model.addAttribute("accountInfo", accountInfo);
        return "admin/index";
    }
}
