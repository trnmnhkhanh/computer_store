package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.ConfigOfHeadphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigOfHeadphoneRepo extends JpaRepository<ConfigOfHeadphone, Long> {
}
