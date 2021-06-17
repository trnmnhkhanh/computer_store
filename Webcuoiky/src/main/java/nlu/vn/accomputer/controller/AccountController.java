package nlu.vn.accomputer.controller;


import nlu.vn.accomputer.entity.Account;
import nlu.vn.accomputer.service.AccountService;
import nlu.vn.accomputer.utils.JsonResult;
import nlu.vn.accomputer.utils.WebUtils;
import nlu.vn.accomputer.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;


@Controller
public class AccountController {


    @Autowired
    private AccountService accountService;
    @Autowired
    public PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginpage(Model model) {
        return "account/login";
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        Account account = new Account();
        modelAndView.addObject("account", account);
        modelAndView.setViewName("account/register");
        return modelAndView;
    }

    @PostMapping("/register")
    public String submitRegist(Model model, @Valid Account account,
                                     BindingResult bindingResult, Validation validation, final RedirectAttributes redirectAttributes) {
        validation.validate(account, bindingResult);
        if (bindingResult.hasErrors()) {
            return "account/register";
        } else {
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            accountService.save(account);
            model.addAttribute("successfull", "Đăng ký thành công !");
            model.addAttribute("account", new Account());
            return "redirect:/login";
        }
    }

    @PostMapping("/register/validate")
    @ResponseBody
    public JsonResult<String> validateEmail(@RequestBody Account account) {
        if (accountService.checkEmail(account.getEmail()))
            return new JsonResult<String>().fail("Email này đã tồn tại. Thử lại");
        return new JsonResult<String>().ok("Email hợp lệ", null);
    }


    @GetMapping(value = "/user")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.findAccountByUsername(auth.getName());
        modelAndView.addObject("accountName", account.getUsername());
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("user/index");
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
//    public String logout(Model model) {
//        return "redirect:/";
//    }


    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "account/profile";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
        }
        return "error/403";
    }

}
