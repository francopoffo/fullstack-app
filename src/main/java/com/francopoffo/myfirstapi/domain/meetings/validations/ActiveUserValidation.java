package com.francopoffo.myfirstapi.domain.meetings.validations;

import com.francopoffo.myfirstapi.domain.meetings.dto.ScheduledMeetingData;
import com.francopoffo.myfirstapi.domain.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveUserValidation implements MeetingSchedulerValidator{

    @Autowired
    private UserRepository repository;

    public void validate(ScheduledMeetingData data){
        var isUserActive = repository.findActiveById(data.userId());
        if(!isUserActive){
            throw new MyValidationException("The informed user is not active. Only active users can schedule meetings.");
        }

    }
}
