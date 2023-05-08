package com.test.meetingapp.handlers;

import com.test.meetingapp.exceptions.WrongRoomParamException;
import com.test.meetingapp.models.Room;
import com.test.meetingapp.services.RoomService;
import com.test.meetingapp.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;


@Component
@RequiredArgsConstructor
public class SignalingHandler implements WebSocketHandler {
    private final RoomService roomService;
    private final SessionService sessionService;
    @Value("${room-identifier-header.name}")
    private String roomIdentifierHeaderName;
    @Value("${room-name-header.name}")
    private String roomNameHeaderName;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        HttpHeaders headers = session.getHandshakeHeaders();
        String roomIdentifier = extractRoomIdentifierFromHeaders(headers);
//        recordNewSessionInRoom(session.getId(), roomIdentifier);
        System.out.println(session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (exception instanceof WrongRoomParamException) {
            session.sendMessage(new TextMessage("LOX" + exception.getMessage()));
            session.close();
        } else {
            session.sendMessage(new TextMessage("NELOX" + exception.getMessage()));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    private String extractRoomNameFromHeaders(HttpHeaders headers) {
        String headerValue;
        try {
            headerValue = headers.get(roomNameHeaderName).get(0);
        } catch (Exception e) {
            throw new WrongRoomParamException("No name header in request");
        }
        return headerValue;
    }

    private String extractRoomIdentifierFromHeaders(HttpHeaders headers) {
        String headerValue;
        try {
            headerValue = headers.get(roomIdentifierHeaderName).get(0);
        } catch (Exception e) {
            throw new WrongRoomParamException("No identifier in request");
        }
        return headerValue;
    }
//    private void recordNewSessionInRoom(String sessionId, String roomIdentifier){
//        Room room = roomService
//    }
}
