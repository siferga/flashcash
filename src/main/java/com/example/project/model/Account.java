package com.example.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private Double amount;
    private String iban;

    public Account plus(double amount){
        this.amount +=amount;
        return this;
    }
    public Account minus(double amount){
        this.amount -= amount;
        return this;
    }

    public void setAmount(double account) {
    }
}
