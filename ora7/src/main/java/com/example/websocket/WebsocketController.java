package com.example.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {

    @MessageMapping("/chat")
    @SendTo("/chat/message")
    public OutgoingChatMessage greeting(IncomingChatMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new OutgoingChatMessage(message);
    }
}
