package nlu.vn.accomputer.service;

import nlu.vn.accomputer.entity.Account;


public interface AccountService {
    Account createAccount(Account account);
    Account findAccountByUsername(String username);
    Account findAccountByEmail(String email);
    Account save(Account account);
    Account findAccountByPassword(String pass);
    boolean checkEmail(String email);
    boolean checkUsername(String username);



}
