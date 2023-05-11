package com.francopoffo.myfirstapi.domain.meetings.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.time.LocalDateTime;

public record ScheduledMeetingData(
        @NotNull
        BigInteger userId,
        @NotNull
        @Future
        LocalDateTime dateTime
) {}
