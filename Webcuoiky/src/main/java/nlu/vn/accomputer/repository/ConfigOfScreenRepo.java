package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.ConfigOfScreen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigOfScreenRepo extends JpaRepository<ConfigOfScreen, Long> {

}
