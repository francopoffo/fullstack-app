package com.francopoffo.myfirstapi.domain.meetings.validations;

import com.francopoffo.myfirstapi.domain.meetings.dto.ScheduledMeetingData;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class InAdvanceTimeValidation implements MeetingSchedulerValidator{

    public void validate(ScheduledMeetingData data){

        var meetingDate = data.dateTime();
        var now = LocalDateTime.now();
        var differenceInMinutes = Duration.between(now, meetingDate).toMinutes();

        if(differenceInMinutes < 30){
            throw new MyValidationException("Meetings cannot be scheduled less than 30 minutes in advance.");
        }
    }
}
