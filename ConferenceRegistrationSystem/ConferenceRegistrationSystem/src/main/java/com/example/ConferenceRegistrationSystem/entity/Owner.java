package com.example.ConferenceRegistrationSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Owner {
@Id
@GeneratedValue
    private int id;
   @NotBlank(message = "name must be fill")
   @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
   @NotBlank(message = "Username not be blank")
    private String username;
    @NotBlank(message = "Password not be blank")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    @Email(message= "email should be in proper format")
    private String email;

}