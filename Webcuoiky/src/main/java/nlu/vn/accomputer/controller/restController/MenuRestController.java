package nlu.vn.accomputer.controller.restController;

import nlu.vn.accomputer.entity.Accessory;
import nlu.vn.accomputer.entity.Image;
import nlu.vn.accomputer.service.AccessoryService;
import nlu.vn.accomputer.service.CategoryService;
import nlu.vn.accomputer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuRestController {

    @Autowired
    AccessoryService accessoryService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Accessory> getListAccessory() {
        List<Accessory> list = accessoryService.findAll();
        for (Accessory accessory : list) {
            System.out.println(accessory);
        }
        return list;

    }
}
