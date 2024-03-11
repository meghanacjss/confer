package com.example.ConferenceRegistrationSystem.controller;

import com.example.ConferenceRegistrationSystem.entity.Event;
import com.example.ConferenceRegistrationSystem.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping("/addevent")
    public ResponseEntity<Event> addEvent(@RequestBody @Valid Event event) {
        Event addedEvent = eventService.add(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEvent);
    }

    @GetMapping("/getevents")
    public ResponseEntity<List<Event>> getEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @PutMapping("/updateevent")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        Event updatedEvent = eventService.updateEvent(event);
        if (updatedEvent != null) {
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteevent/{eid}")
    public ResponseEntity<String> deleteEvent(@PathVariable int eid) {
        System.out.println(eid);
        String result = eventService.deleteEvent(eid);
        if (result.equals("success")) {
            return ResponseEntity.ok("Event deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping("/addevent")
//
//    public Event addEvent(@RequestBody Event event){
//
//        return eventService.add(event);
//    }
//    @GetMapping("/getevents")
//
//    public List<Event> getevents(){
//        return eventService.getAllEvents();
//    }
//
//    @PutMapping("/updateevent")
//
//    public Event updateevent(@RequestBody Event event){
//        return eventService.updateEvent(event);
//    }
//    @DeleteMapping("/deleteevent/{eid}")
//
//    public String deleteevent(@PathVariable int eid){
//        return eventService.deleteEvent(eid);
//    }
}
