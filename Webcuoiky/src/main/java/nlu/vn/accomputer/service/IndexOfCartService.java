package nlu.vn.accomputer.service;

import nlu.vn.accomputer.entity.IndexOfCart;
import nlu.vn.accomputer.entity.ShoppingCart;

import java.util.List;

public interface IndexOfCartService {
    List<IndexOfCart> getIndexOfCartByShoppingCart(ShoppingCart shoppingCart);
}
