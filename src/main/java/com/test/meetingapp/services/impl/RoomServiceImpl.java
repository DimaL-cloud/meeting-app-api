package com.test.meetingapp.services.impl;

import com.test.meetingapp.models.Room;
import com.test.meetingapp.repositories.RoomRepository;
import com.test.meetingapp.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;

    public Room findRoomByIdentifier(String identifier) {
        return repository.findByIdentifier(identifier);
    }
}
