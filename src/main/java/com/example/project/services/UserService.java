package com.example.project.services;


import com.example.project.model.Account;
import com.example.project.model.User;
import com.example.project.repository.AccountRepository;
import com.example.project.repository.UserRepository;
import com.example.project.services.form.SignUpForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, AccountRepository accountRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        
    }

    public User registration(SignUpForm form) {
        User user = new User();
        Account account = new Account();
        account.setAmount(0.0);
        user.setAccount(account);
        user.setFirstname(form.getFirstname());
        user.setLastname(form.getLastname());
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        return userRepository.save(user);
    }


}
