package com.test.meetingapp.services.impl;

import com.test.meetingapp.exceptions.RoomAlreadyExistsException;
import com.test.meetingapp.exceptions.UnexistingRoomException;
import com.test.meetingapp.models.Room;
import com.test.meetingapp.repositories.RoomRepository;
import com.test.meetingapp.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public Room findRoomByIdentifier(String identifier) {
//        return repository.findByIdentifier(identifier);
        return null;
    }

    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> allRooms = roomRepository.findAll();

        return new ResponseEntity<>(allRooms, HttpStatus.OK);
    }

    public ResponseEntity<Room> getRoomByIdentifier(String identifier) {
        Room room = roomRepository
                .findByIdentifier(identifier)
                .orElseThrow(() -> new UnexistingRoomException(identifier));

        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    public ResponseEntity<Void> createRoom(Room room) {
        try {
            roomRepository.save(room);
        } catch (Exception e) {
            throw new RoomAlreadyExistsException(room.getIdentifier());
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<Void> editRoom(String identifier, Room room) {
        Room roomEntity = roomRepository
                .findByIdentifier(identifier)
                .orElseThrow(() -> new UnexistingRoomException(room.getIdentifier()));

        room.setId(roomEntity.getId());

        roomRepository.save(room);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> deleteRoomByIdentifier(String identifier) {
        Room room = roomRepository
                .findByIdentifier(identifier)
                .orElseThrow(() -> new UnexistingRoomException(identifier));

        roomRepository.delete(room);

        return ResponseEntity.noContent().build();
    }
}
