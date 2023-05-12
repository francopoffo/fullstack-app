package com.francopoffo.myfirstapi.domain.meetings.validations;

import com.francopoffo.myfirstapi.domain.meetings.dto.ScheduledMeetingData;

public interface MeetingSchedulerValidator {

    void validate(ScheduledMeetingData data);
}
