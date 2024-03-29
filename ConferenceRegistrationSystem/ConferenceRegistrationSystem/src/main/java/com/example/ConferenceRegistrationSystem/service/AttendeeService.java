package com.example.ConferenceRegistrationSystem.service;

import com.example.ConferenceRegistrationSystem.entity.Attendee;
import com.example.ConferenceRegistrationSystem.entity.Event;
import com.example.ConferenceRegistrationSystem.exception.UserNotFoundException;
import com.example.ConferenceRegistrationSystem.repository.AttendeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

 //   public Attendee createAttendee(String aname, String email, String affiliation) {
//        Attendee attendee = new Attendee();
//        attendee.setAname(aname);
//        attendee.setEmail(email);
//        attendee.setAffiliation(affiliation);
    public Attendee createAttendee(@Valid Attendee attendee){

        return attendeeRepository.save(attendee);
    }

    public List<Attendee> getAllAttendees() {
        return attendeeRepository.findAll();
    }

    public Optional<Attendee> getAttendeeById(int aid) throws UserNotFoundException{
        return attendeeRepository.findById(aid);
    }

    public void associateAttendeeWithEvent(int aid, Event event) {
        Optional<Attendee> optionalAttendee = attendeeRepository.findById(aid);

        if (optionalAttendee.isPresent()) {
            Attendee attendee = optionalAttendee.get();
            attendee.setEvent(event);
            attendeeRepository.save(attendee);
        }

    }

//    public String deleteAttendeeById(int aid){
//        attendeeRepository.deleteById(aid);
//        return "id deleted";
//    }

}
