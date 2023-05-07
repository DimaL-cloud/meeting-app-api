package com.test.meetingapp.repositories;

import com.test.meetingapp.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
