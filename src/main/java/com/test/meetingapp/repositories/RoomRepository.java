package com.test.meetingapp.repositories;

import com.test.meetingapp.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Optional<Room> findByIdentifier(String identifier);
}
