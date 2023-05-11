package com.francopoffo.myfirstapi.domain.meetings.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

public record ScheduledMeetingDetailedData(BigInteger id, BigInteger userId, LocalDateTime dateTime) {
}
