package nlu.vn.accomputer.repository;


import nlu.vn.accomputer.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {

}
