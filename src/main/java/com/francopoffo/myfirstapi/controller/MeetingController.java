package com.francopoffo.myfirstapi.controller;

import com.francopoffo.myfirstapi.domain.meetings.MeetingService;
import com.francopoffo.myfirstapi.domain.meetings.dto.ScheduledMeetingData;
import com.francopoffo.myfirstapi.domain.meetings.dto.ScheduledMeetingDetailedData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @PostMapping
    @Transactional
    public ResponseEntity scheduleMeeting(@RequestBody @Valid ScheduledMeetingData data){
        meetingService.schedule(data);
        return ResponseEntity.ok().build();
    }

}
