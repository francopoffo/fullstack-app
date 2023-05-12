package com.francopoffo.myfirstapi.domain.meetings.validations;

import com.francopoffo.myfirstapi.domain.meetings.dto.ScheduledMeetingData;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class TimeAndDayValidation implements MeetingSchedulerValidator{

    public void validate(ScheduledMeetingData data){
        var meetingDate = data.dateTime();
        var sunday = meetingDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeOpening = meetingDate.getHour() < 7;
        var afterClosing = meetingDate.getHour() > 18;

        if(sunday || beforeOpening || afterClosing){
            throw new MyValidationException("Meetings can only be scheduled from Monday to Saturday from 7 am to 19 pm.");
        }
    }
}
