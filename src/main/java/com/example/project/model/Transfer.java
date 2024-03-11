package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer transferId;
    private LocalDateTime date;
    @ManyToOne
    private User from;
    @ManyToOne
    private User to;
    private Double amountBeforeFee;
    private Double amountAfterFee;
}
