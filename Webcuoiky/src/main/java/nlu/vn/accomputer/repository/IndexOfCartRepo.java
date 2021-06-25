package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.IndexOfCart;
import nlu.vn.accomputer.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexOfCartRepo extends JpaRepository<IndexOfCart, Long> {
    List<IndexOfCart> findByShoppingCart(ShoppingCart shoppingCart);

}
