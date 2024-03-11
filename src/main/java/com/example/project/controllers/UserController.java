package com.example.project.controllers;

import ch.qos.logback.core.model.Model;
import com.example.project.services.MessageService;
import com.example.project.services.UserService;
import com.example.project.services.form.AddIbanForm;
import com.example.project.services.form.ContactForm;
import com.example.project.services.form.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;
    private final MessageService messageService;
    public UserController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/")
    public ModelAndView home(Model model) {
        return new ModelAndView("index");
    }

    @PostMapping("/signup")
    public ModelAndView processRequest(@ModelAttribute("signUpForm")SignUpForm form) {
        userService.registration(form);
        return new ModelAndView("signin");
    }

    @GetMapping ("/signup")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("signup","signUpForm",new SignUpForm());
    }

    @GetMapping ("/home")
    public String logOff(){
        return "home";
    }
    @GetMapping ("/addIban")
    public ModelAndView addIbanForm()
    { return new  ModelAndView("addIban","addIbanForm", new AddIbanForm()); }
    @GetMapping ("/logOut")
    public String logOut(){
        return "signin";
    }
    @PostMapping("/contactForm")
    public ModelAndView contactForm(@ModelAttribute("contactForm") ContactForm form) {
        messageService.submitContactForm(form);
        return new ModelAndView("messageAfterContactForm");
    }
    @GetMapping("/contactForm")
    public ModelAndView showContactForm() {
        return new ModelAndView("contactForm","contactForm",new ContactForm());
    }


}
