package nlu.vn.accomputer.repository;


import nlu.vn.accomputer.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill, Long> {
}
