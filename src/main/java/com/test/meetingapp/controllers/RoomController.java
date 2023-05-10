package com.test.meetingapp.controllers;

import com.test.meetingapp.models.Room;
import com.test.meetingapp.services.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Room> getRoomByIdentifier(@PathVariable("identifier") String identifier) {
        return roomService.getRoomByIdentifier(identifier);
    }

    @PostMapping
    public ResponseEntity<Void> createRoom(@Valid @RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @PutMapping("/{identifier}")
    public ResponseEntity<Void> editRoomByIdentifier(@PathVariable("identifier") String identifier,
                                                     @Valid @RequestBody Room room) {
        return roomService.editRoom(identifier, room);
    }

    @DeleteMapping("/{identifier}")
    public ResponseEntity<Void> deleteRoomByIdentifier(@PathVariable("identifier") String identifier) {
        return roomService.deleteRoomByIdentifier(identifier);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllRooms() {
        return roomService.deleteAllRooms();
    }
}
