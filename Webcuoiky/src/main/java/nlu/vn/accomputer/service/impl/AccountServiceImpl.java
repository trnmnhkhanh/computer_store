package nlu.vn.accomputer.service.impl;

import nlu.vn.accomputer.entity.Account;
import nlu.vn.accomputer.entity.Role;
import nlu.vn.accomputer.repository.AccountRepo;
import nlu.vn.accomputer.repository.RoleRepo;
import nlu.vn.accomputer.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepo.findAccountByUsername(username);
    }

    @Override
    public Account findAccountByEmail(String email) {
        return accountRepo.findAccountByEmail(email);
    }

    @Override
    public Account save(Account account) {
        List<Role> roles = new ArrayList<>();
        Role role = roleRepo.findByRoleName("ROLE_USER");
        roles.add(role);
        account.setRoles(roles);
        return  accountRepo.save(account);
    }

    @Override
    public Account findAccountByPassword(String pass) {
        return accountRepo.findAccountByPassword(pass);
    }

    @Override
    public boolean checkEmail(String email) {
        return accountRepo.existsByEmail(email);
    }
    @Override
    public boolean checkUsername(String username) {
        return accountRepo.existsByUsername(username);
    }

}
