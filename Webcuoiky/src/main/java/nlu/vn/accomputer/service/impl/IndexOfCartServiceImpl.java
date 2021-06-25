package nlu.vn.accomputer.service.impl;

import nlu.vn.accomputer.entity.IndexOfCart;
import nlu.vn.accomputer.entity.ShoppingCart;
import nlu.vn.accomputer.repository.IndexOfCartRepo;
import nlu.vn.accomputer.service.IndexOfCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IndexOfCartServiceImpl implements IndexOfCartService {

    @Autowired
    IndexOfCartRepo indexOfCartRepo;
    @Override
    public List<IndexOfCart> getIndexOfCartByShoppingCart(ShoppingCart shoppingCart) {
        return indexOfCartRepo.findByShoppingCart(shoppingCart);
    }
}
