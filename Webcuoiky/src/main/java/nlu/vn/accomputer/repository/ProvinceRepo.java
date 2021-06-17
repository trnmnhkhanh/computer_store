package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepo extends JpaRepository<Province, Long> {
}
