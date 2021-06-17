package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.PersistentLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersistentLoginRepo extends JpaRepository<PersistentLogin, Long> {
}
