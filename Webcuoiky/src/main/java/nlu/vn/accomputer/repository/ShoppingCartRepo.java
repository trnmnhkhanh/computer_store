package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.Account;
import nlu.vn.accomputer.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {
 ShoppingCart findByAccount(Account account);
}
