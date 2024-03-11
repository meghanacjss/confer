package com.example.ConferenceRegistrationSystem.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentModel {

    private int pid;
    private long amount;
    private String paymentDate;


}
