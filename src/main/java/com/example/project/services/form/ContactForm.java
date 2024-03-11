package com.example.project.services.form;

import lombok.Data;

@Data
public class ContactForm {
    private String firstname;
    private String email;
    private String subject;
    private String message;
}
