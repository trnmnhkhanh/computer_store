package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    Account findAccountByUsername(String username);
    Account findAccountByEmail(String email);
    Account findAccountByPassword(String pass);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);


}
