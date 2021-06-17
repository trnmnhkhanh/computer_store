package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepo extends JpaRepository<BillDetail, Long> {
}
