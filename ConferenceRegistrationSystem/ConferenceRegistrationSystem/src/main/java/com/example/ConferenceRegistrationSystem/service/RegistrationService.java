package com.example.ConferenceRegistrationSystem.service;

import com.example.ConferenceRegistrationSystem.entity.Attendee;
import com.example.ConferenceRegistrationSystem.entity.Event;
import com.example.ConferenceRegistrationSystem.entity.Registration;
import com.example.ConferenceRegistrationSystem.repository.RegistrationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration createRegistration(@Valid Event event, Attendee attendee, Date registrationDate, long registrationAmount) {
        Registration registration = new Registration();
        registration.setEvent(event);
        registration.setAttendee(attendee);
        registration.setRdate(registrationDate);
        registration.setRamount(registrationAmount);

        return registrationRepository.save(registration);
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public List<Registration> getRegistrationsByEvent(Event event) {
        return registrationRepository.findByEvent(event);
    }
    public List<Registration> getRegistrationsByAttendee(Attendee attendee) {
        return registrationRepository.findByAttendee(attendee);
    }

    public Registration getRegistrationById(int rid) {
        return registrationRepository.findById(rid).orElse(null);
    }
//    public String  deleteRegistrationById(int rid) {
//        if (registrationRepository.existsById(rid)) {
//            registrationRepository.deleteById(rid);
//        }
//        return "deleted id";
//    }
}
