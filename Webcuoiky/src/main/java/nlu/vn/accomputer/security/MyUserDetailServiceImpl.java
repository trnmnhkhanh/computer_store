package nlu.vn.accomputer.security;

import nlu.vn.accomputer.entity.Account;
import nlu.vn.accomputer.entity.Role;
import nlu.vn.accomputer.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account user = accountService.findAccountByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("Username Not Found Exception");
        }
        System.out.println("Found User: " + user);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        MyUserDetail userDetail = new MyUserDetail(user.getEmail(), user.getPassword(), grantedAuthorities);
        userDetail.setName(user.getUsername());
        userDetail.setEmail(user.getEmail());
        userDetail.setStatus(user.isEnabled());
        return userDetail;
    }
//
}
