package com.francopoffo.myfirstapi.domain.meetings;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface MeetingRepository extends JpaRepository<Meeting, BigInteger> {
}
