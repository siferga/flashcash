package com.example.project.services;

import com.example.project.model.Message;
import com.example.project.repository.MessageRepository;
import com.example.project.repository.UserRepository;
import com.example.project.services.form.ContactForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessageService(PasswordEncoder passwordEncoder, MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;

    }

    public void submitContactForm(ContactForm form) {
    }

   /* public Message submitContactForm(ContactForm form) {
        Message message = new Message();
        message.setName(form.getName());
        message.setEmail(form.getEmail());
        message.setMessage(form.getMessage());
        // On peut ajouter d'autres actions ici, telles que l'envoi d'un e-mail
        // ou la sauvegarde dans une base de données
        messageRepository.save(message);

    }*/


}
