package com.example.project.controllers;

import ch.qos.logback.core.model.Model;
import com.example.project.model.User;
import com.example.project.services.AccountService;
import com.example.project.services.MessageService;
import com.example.project.services.SessionService;
import com.example.project.services.UserService;
import com.example.project.services.form.AddIbanForm;
import com.example.project.services.form.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    private final AccountService accountService;
    private final SessionService sessionService;
    private final UserService userService;

    public AccountController(AccountService accountService, SessionService sessionService, UserService userService) {
        this.accountService = accountService;
        this.sessionService = sessionService;
        this.userService = userService;
    }


    /*********************************** ADD IBAN FORM ******************************************/
    @PostMapping("/addIban")
    public ModelAndView submitIbanForm(@ModelAttribute("addIbanForm") AddIbanForm form) {
        accountService.submitIbanForm(form);
        return new ModelAndView("index");
    }
    @GetMapping ("/addIban")
    public ModelAndView addIbanForm(Model model)
    {
        return new  ModelAndView("addIban","addIbanForm", new AddIbanForm()); }

/*********************************** ADD CASH ******************************************/
}



