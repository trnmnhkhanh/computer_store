package nlu.vn.accomputer.controller;

import nlu.vn.accomputer.entity.Accessory;
import nlu.vn.accomputer.service.AccessoryService;
import nlu.vn.accomputer.service.CategoryService;
import nlu.vn.accomputer.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller("Shop grrid")
public class ShopgridController {
    @Autowired
    AccessoryService accessoryServic;

    @Autowired
    ManufacturerService manufacturerService;

    @Autowired
    CategoryService categoryService;
    @Autowired
    AccessoryService accessoryService;

    @GetMapping("/shop-grid/category={categoryName}")
    String showCategory(Model model,
                        @PathVariable(name = "categoryName") String categoryName){
        List<Accessory> listOfCategory = accessoryService.findAllByManufacturerName(categoryName);
        model.addAttribute("listOfCategory", listOfCategory);
        System.out.println(listOfCategory);
        //tim kiem cac san pham khac
        model.addAttribute("list1", accessoryService.findLatestPage(PageRequest.of(0,3)));
        model.addAttribute("list2", accessoryService.findLatestPage(PageRequest.of(1, 3)));
        model.addAttribute("list3", accessoryService.findBestsellerPage(PageRequest.of(0, 3)));
        model.addAttribute("list4", accessoryService.findBestsellerPage(PageRequest.of(1, 3)));
        model.addAttribute("list5", accessoryService.findTopSalePage(PageRequest.of(0, 3)));
        model.addAttribute("list6", accessoryService.findTopSalePage(PageRequest.of(1, 3)));

        return "user/shop-grid";

    }
    @GetMapping("/shop-grid/")
    public String showGrid(){
        return "user/shop-grid";
    }

}
