package com.example.ConferenceRegistrationSystem.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttendeeModel {

    private int aid;
    private String aname;
    private String email;
    private String affiliation;



}
