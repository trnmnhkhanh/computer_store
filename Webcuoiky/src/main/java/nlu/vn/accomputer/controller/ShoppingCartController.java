package nlu.vn.accomputer.controller;

import nlu.vn.accomputer.entity.Accessory;
import nlu.vn.accomputer.entity.Account;
import nlu.vn.accomputer.entity.IndexOfCart;
import nlu.vn.accomputer.entity.ShoppingCart;
import nlu.vn.accomputer.service.AccessoryService;
import nlu.vn.accomputer.service.AccountService;
import nlu.vn.accomputer.service.IndexOfCartService;
import nlu.vn.accomputer.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@SessionAttributes("loggedInUser")
public class ShoppingCartController {
    @Autowired
    AccountService accountService;
    @Autowired
    AccessoryService accessoryService;
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    IndexOfCartService indexOfCartService;

    @ModelAttribute("loggedInUser")
    public Account loggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return accountService.findAccountByEmail(auth.getName());
    }
    public Account getSessionUser(HttpServletRequest request) {
        return (Account) request.getSession().getAttribute("loggedInUser");
    }
    @GetMapping("/cart")
    public String cartPage(HttpServletRequest res, Model model) {
        Account currentUser = getSessionUser(res);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Map<Long,String> quantity = new HashMap<Long,String>();
        List<Accessory> accessoryList = new ArrayList<Accessory>();
        if(auth == null || auth.getPrincipal() == "anonymousUser")     //Lay tu cookie
        {
            Cookie cl[] = res.getCookies();
            Set<Long> idList = new HashSet<Long>();
            for(int i=0; i< cl.length; i++)
            {
                if(cl[i].getName().matches("[0-9]+"))
                {
                    idList.add(Long.parseLong(cl[i].getName()));
                    quantity.put(Long.parseLong(cl[i].getName()), cl[i].getValue());
                }

            }
            accessoryList = accessoryService.getAllAccessoryByList(idList);
        }else     //Lay tu database
        {
            ShoppingCart cart = shoppingCartService.getCartByAccount(currentUser);
            if(cart != null)
            {
                List<IndexOfCart> listOfCartIndex = indexOfCartService.getIndexOfCartByShoppingCart(cart);
                for(IndexOfCart index: listOfCartIndex)
                {
                    accessoryList.add(index.getAccessory());
                    quantity.put(index.getAccessory().getId(), Integer.toString(index.getQuantity()));
                }
            }
        }
        model.addAttribute("checkEmpty",accessoryList.size());
        model.addAttribute("cart",accessoryList);
        model.addAttribute("quantity",quantity);

        return "user/shopping-cart";
    }

}
