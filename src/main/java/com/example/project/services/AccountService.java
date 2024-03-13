package com.example.project.services;

import com.example.project.model.Account;
import com.example.project.model.User;
import com.example.project.repository.AccountRepository;
import com.example.project.repository.UserRepository;
import com.example.project.services.form.AddIbanForm;
import com.example.project.services.form.SignUpForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class AccountService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final SessionService sessionService;

    public AccountService(PasswordEncoder passwordEncoder, UserRepository userRepository, AccountRepository accountRepository, SessionService sessionService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.sessionService = sessionService;
    }

    public Account submitIbanForm(AddIbanForm form) {
       User user = sessionService.sessionUser();
       user.getAccount().setIban(form.getIban());
       return accountRepository.save(user.getAccount());
    }

}
