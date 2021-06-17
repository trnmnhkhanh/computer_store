package nlu.vn.accomputer.validation;

import nlu.vn.accomputer.entity.Account;
import nlu.vn.accomputer.repository.AccountRepo;
import nlu.vn.accomputer.service.AccountService;
import nlu.vn.accomputer.utils.SpringUtil;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class Validation implements Validator {
    AccountService accountService = SpringUtil.appCt.getBean(AccountService.class);

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    // check mail exist
    private boolean emailExist(String email){
        AccountRepo accountRepo = SpringUtil.appCt.getBean(AccountRepo.class);
        if (accountRepo.findAccountByEmail(email) !=null) {
            return true;
        } return false;
    }
    //check username exist
    private boolean usernameExist(String username){
        AccountRepo accountRepo = SpringUtil.appCt.getBean(AccountRepo.class);
        if (accountRepo.findAccountByUsername(username) !=null) {
            return true;
        } return false;
    }
    //check wrong password
    //check username exist

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Account.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Account account= (Account) target;

        //Xac thuc email
        if (account.getEmail().equals("")){
            errors.rejectValue("email", "null");
        } else if (!VALID_EMAIL_ADDRESS_REGEX.matcher(account.getEmail()).matches()){
            errors.rejectValue("email","mail.invalid");
        } else if (emailExist(account.getEmail())){
            errors.rejectValue("email", "mail.exist");
        }
        //Xac thuc username
        if(account.getUsername().equals("")) {
            errors.rejectValue("username", "null");
        } else if (usernameExist(account.getUsername())){
            errors.rejectValue("username", "username.exist");
        } else if (account.getUsername().contains(" ")) { //check xem co khoang trang hay khong
            errors.rejectValue("username", "username.whiteSpace");
        }

        //Xac thuc pass
        if (account.getPassword().equals("")){
            errors.rejectValue("password","null");
        } else if (account.getPassword().length()<8){
            errors.rejectValue("password","password.minlength");
        } else if (!account.getRepassword().equals(account.getPassword())){
            errors.rejectValue("repassword", "repass.invalid");
        }

        if(account.getRepassword().equals("")){
            errors.rejectValue("repassword","null");
        }

    }
}
