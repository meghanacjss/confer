package com.example.ConferenceRegistrationSystem.service;

import com.example.ConferenceRegistrationSystem.entity.Event;
import com.example.ConferenceRegistrationSystem.repository.AttendeeRepository;
import com.example.ConferenceRegistrationSystem.repository.EventRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AttendeeRepository attendeeRepository;

    public Event add(@Valid Event event){
      return eventRepository.save(event);
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event updateEvent(Event event){
        Event updateevent = eventRepository.findById(event.getEid()).orElse(null);
        if (updateevent != null) {
            updateevent.setEname(event.getEname());
            updateevent.setDate(event.getDate());
            updateevent.setVenue(event.getVenue());
            eventRepository.save(updateevent);
            return updateevent;
        }
        return null;
    }

    public String deleteEvent(int eid){
        System.out.println(" deleteEvent "+eid);
        if (eventRepository.existsById(eid)) {

         //   attendeeRepository.deleteById();
            eventRepository.deleteById(eid);
            return "deleted " + eid;
        }else{
            return "id is not exist";
        }
    }
    public Event getEventById(int eid) {
        return eventRepository.findById(eid).orElse(null);
    }
}
