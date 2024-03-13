package com.example.project.services.form;

import lombok.Data;

@Data
public class AddIbanForm {
    private String iban;

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }
}
