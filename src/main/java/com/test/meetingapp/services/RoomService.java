package com.test.meetingapp.services;

import com.test.meetingapp.models.Room;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomService {
    ResponseEntity<List<Room>> getAllRooms();

    ResponseEntity<Room> getRoomByIdentifier(String identifier);

    ResponseEntity<Void> createRoom(Room room);

    ResponseEntity<Void> editRoom(String identifier, Room room);

    ResponseEntity<Void> deleteRoomByIdentifier(String identifier);

    ResponseEntity<Void> deleteAllRooms();
}
