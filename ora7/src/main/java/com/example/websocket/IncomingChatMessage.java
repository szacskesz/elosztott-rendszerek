package com.example.websocket;

import lombok.Data;

@Data
public class IncomingChatMessage {
    private String message;
    private String sender;
    private String target;
}
