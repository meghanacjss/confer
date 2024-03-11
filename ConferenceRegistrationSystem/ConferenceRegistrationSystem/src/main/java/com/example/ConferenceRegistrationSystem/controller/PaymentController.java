package com.example.ConferenceRegistrationSystem.controller;

import com.example.ConferenceRegistrationSystem.entity.Payment;
import com.example.ConferenceRegistrationSystem.entity.Registration;
import com.example.ConferenceRegistrationSystem.service.PaymentService;
import com.example.ConferenceRegistrationSystem.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/create/{rid}")
    public ResponseEntity<Payment> createPayment(@RequestBody @Valid Payment payment, @PathVariable int rid) {
        Registration registration = registrationService.getRegistrationById(rid);
        if (registration == null) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

        payment.setRegistration(registration);
        Payment createdPayment = paymentService.createPayment(payment);

        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/byRegistration/{rid}")
    public ResponseEntity<List<Payment>> getPaymentsByRegistration(@PathVariable int rid) {
        Registration registration = registrationService.getRegistrationById(rid);
        if (registration == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Payment> payments = paymentService.getPaymentsByRegistration(registration);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/totalPayments/{rid}")
    public ResponseEntity<Long> calculateTotalPayments(@PathVariable int rid) {
        Registration registration = registrationService.getRegistrationById(rid);
        if (registration == null) {
            return new ResponseEntity<>(0L, HttpStatus.NOT_FOUND);
        }

        long totalPayments = paymentService.calculateTotalPayments(registration);
        return new ResponseEntity<>(totalPayments, HttpStatus.OK);
    }





























//    @PostMapping("/create/{rid}")
//    public Payment createPayment(@RequestBody Payment payment,@PathVariable int rid) {
////        Registration registration = payment.getRegistration();
////        long amount = payment.getAmount();
////        String paymentDate = payment.getPaymentDate();
//    Registration registration=registrationService.getRegistrationById(rid);
//    payment.setRegistration(registration);
//        return paymentService.createPayment(payment);
//    }
//
//    @GetMapping("/all")
//    public List<Payment> getAllPayments() {
//        return paymentService.getAllPayments();
//    }
//
//    @GetMapping("/byRegistration/{rid}")
//    public List<Payment> getPaymentsByRegistration(@PathVariable int rid) {
//        Registration registration = new Registration();
//        registration.setRid(rid);
//
//        return paymentService.getPaymentsByRegistration(registration);
//    }
//
//    @GetMapping("/totalPayments/{rid}")
//    public long calculateTotalPayments(@PathVariable int rid) {
//        Registration registration = new Registration();
//        registration.setRid(rid);
//
//        return paymentService.calculateTotalPayments(registration);
//    }


}
