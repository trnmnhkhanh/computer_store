package nlu.vn.accomputer.controller;

import nlu.vn.accomputer.service.AccessoryService;
import nlu.vn.accomputer.service.CategoryService;
import nlu.vn.accomputer.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("Shop grrid")
public class ShopgridController {
    @Autowired
    AccessoryService accessoryServic;

    @Autowired
    ManufacturerService manufacturerService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/shop-grid")
    public String showGrid(){
        return "user/shop-grid";
    }

}
