package nlu.vn.accomputer.service;

import nlu.vn.accomputer.entity.Account;
import nlu.vn.accomputer.entity.ShoppingCart;

public interface ShoppingCartService {
ShoppingCart getCartByAccount(Account account);
}
