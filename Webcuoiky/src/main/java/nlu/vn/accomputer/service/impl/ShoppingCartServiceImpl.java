package nlu.vn.accomputer.service.impl;

import nlu.vn.accomputer.entity.Account;
import nlu.vn.accomputer.entity.ShoppingCart;
import nlu.vn.accomputer.repository.ShoppingCartRepo;
import nlu.vn.accomputer.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartRepo shoppingCartRepo;


    @Override
    public ShoppingCart getCartByAccount(Account account) {
        return shoppingCartRepo.findByAccount(account);
    }
}
