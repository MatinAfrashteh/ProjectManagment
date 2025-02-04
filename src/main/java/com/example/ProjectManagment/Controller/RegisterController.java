package com.example.ProjectManagment.Controller;

import com.example.ProjectManagment.Entities.UserAccount;
import com.example.ProjectManagment.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/register")
    public String register(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("user_account",userAccount);
        return "register";
    }

    @PostMapping("/register/save")
    public String newregister(UserAccount user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userAccountRepository.save(user);
        return "redirect:/register";
    }
}
