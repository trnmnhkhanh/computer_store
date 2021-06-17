package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.ConfigOfChair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigOfChairRepo extends JpaRepository<ConfigOfChair, Long> {
}
