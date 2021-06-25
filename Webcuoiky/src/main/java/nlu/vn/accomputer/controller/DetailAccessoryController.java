package nlu.vn.accomputer.controller;


import nlu.vn.accomputer.entity.Accessory;
import nlu.vn.accomputer.entity.Manufacturer;
import nlu.vn.accomputer.service.AccessoryService;
import nlu.vn.accomputer.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class DetailAccessoryController {
    @Autowired
    AccessoryService accessoryService;
    @Autowired
    ManufacturerService manufacturerService;

    @GetMapping(value = "/detail/id={id}")
    public String showDetail(Model model,
                             @PathVariable(name = "id") Long id) {
        Accessory accessory = accessoryService.findDetailById(id);
        Manufacturer manufacturer = manufacturerService.findOneById(accessory.getManufacturer().getId());
        model.addAttribute("accessory", accessory);
        System.out.println(accessory);
        model.addAttribute("relatedList", accessoryService.findRelatedProduct(accessory.getManufacturer().getName(), accessory.getCategory().getName(), 4));
        return "user/shop-details";
    }

    @GetMapping(value = "/detail/")
    public String detail() {
        return "user/shop-details";
    }
}
