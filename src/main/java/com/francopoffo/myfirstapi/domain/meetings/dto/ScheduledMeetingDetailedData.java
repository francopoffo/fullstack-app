package com.francopoffo.myfirstapi.domain.meetings.dto;

import com.francopoffo.myfirstapi.domain.meetings.Meeting;

import java.math.BigInteger;
import java.time.LocalDateTime;

public record ScheduledMeetingDetailedData(BigInteger id, BigInteger userId, LocalDateTime dateTime) {
    public ScheduledMeetingDetailedData(Meeting meeting) {
        this(meeting.getId(), meeting.getUser().getId(), meeting.getDateTime());
    }
}
