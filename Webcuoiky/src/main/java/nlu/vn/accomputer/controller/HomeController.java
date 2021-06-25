package nlu.vn.accomputer.controller;


import nlu.vn.accomputer.entity.Accessory;
import nlu.vn.accomputer.entity.Category;
import nlu.vn.accomputer.service.AccessoryService;
import nlu.vn.accomputer.service.CategoryService;
import nlu.vn.accomputer.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller("WebHome")
public class HomeController {
    @Autowired
    private AccessoryService accessoryService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"/"} )
    public String showHome(Model model){
        List<Accessory> list = accessoryService.findAll();
        List<Category> categoryList = categoryService.findAll();
        System.out.println(categoryList);
        System.out.println(categoryList);
        model.addAttribute("list", list);
        model.addAttribute("categoryList", categoryList);

        model.addAttribute("list1", accessoryService.findLatestPage(PageRequest.of(0,3)));
        model.addAttribute("list2", accessoryService.findLatestPage(PageRequest.of(1, 3)));
        model.addAttribute("list3", accessoryService.findBestsellerPage(PageRequest.of(0, 3)));
        model.addAttribute("list4", accessoryService.findBestsellerPage(PageRequest.of(1, 3)));
        model.addAttribute("list5", accessoryService.findTopSalePage(PageRequest.of(0, 3)));
        model.addAttribute("list6", accessoryService.findTopSalePage(PageRequest.of(1, 3)));
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
