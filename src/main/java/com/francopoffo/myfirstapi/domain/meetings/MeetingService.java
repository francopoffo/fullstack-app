package com.francopoffo.myfirstapi.domain.meetings;

import com.francopoffo.myfirstapi.domain.ValidationException;
import com.francopoffo.myfirstapi.domain.meetings.dto.ScheduledMeetingData;
import com.francopoffo.myfirstapi.domain.users.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private UserRepository userRepository;

    public void schedule(ScheduledMeetingData data){

        if(!userRepository.existsById(data.userId())){
            throw new ValidationException("User id was not found.");
        }

        var user = userRepository.getReferenceById(data.userId());
        var meeting = new Meeting(null, user, data.dateTime());
        meetingRepository.save(meeting);

    }
}
