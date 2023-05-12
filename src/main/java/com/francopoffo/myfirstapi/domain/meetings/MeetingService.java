package com.francopoffo.myfirstapi.domain.meetings;

import com.francopoffo.myfirstapi.domain.meetings.dto.ScheduledMeetingDetailedData;
import com.francopoffo.myfirstapi.domain.meetings.validations.MyValidationException;
import com.francopoffo.myfirstapi.domain.meetings.dto.ScheduledMeetingData;
import com.francopoffo.myfirstapi.domain.meetings.validations.MeetingSchedulerValidator;
import com.francopoffo.myfirstapi.domain.users.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private List<MeetingSchedulerValidator> validatorList;


    public ScheduledMeetingDetailedData schedule(ScheduledMeetingData data){

        if(!userRepository.existsById(data.userId())){
            throw new MyValidationException("User id was not found.");
        }

        validatorList.forEach(v -> v.validate(data));

        var user = userRepository.getReferenceById(data.userId());
        var meeting = new Meeting(null, user, data.dateTime());
        meetingRepository.save(meeting);

        return new ScheduledMeetingDetailedData(meeting);
    }
}
