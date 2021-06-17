package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.ConfigOfMouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigOfMouseRepo extends JpaRepository<ConfigOfMouse, Long> {
}
