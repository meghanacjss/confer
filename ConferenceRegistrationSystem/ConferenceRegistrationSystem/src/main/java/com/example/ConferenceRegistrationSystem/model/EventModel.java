package com.example.ConferenceRegistrationSystem.model;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventModel {

    private int eid;
    private String ename;
    private Date date;
    private String venue;


}
