package com.test.meetingapp.services.impl;

import com.test.meetingapp.repositories.SessionRepository;
import com.test.meetingapp.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {
    private final SessionRepository repository;

}
