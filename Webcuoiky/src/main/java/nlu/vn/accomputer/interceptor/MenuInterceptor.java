package nlu.vn.accomputer.interceptor;


import nlu.vn.accomputer.entity.Accessory;
import nlu.vn.accomputer.service.AccessoryService;
import nlu.vn.accomputer.service.CategoryService;
import nlu.vn.accomputer.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Component
public class MenuInterceptor implements HandlerInterceptor {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AccessoryService accessoryService;
    @Autowired
    private PriceService priceService;

    public int getSalePercent(Long accessory_id){
        Accessory accessory = accessoryService.findOneById(accessory_id);
        int salePercent = (int)((accessory.getPrice().getPrice() - accessory.getPrice().getSalePrice())/accessory.getPrice().getPrice())*100;
        return salePercent;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<Accessory> list = accessoryService.findAll();
        request.setAttribute("categoryList", categoryService.findAll());
        request.setAttribute("accessoryList", list);
        return true;


    }

}
