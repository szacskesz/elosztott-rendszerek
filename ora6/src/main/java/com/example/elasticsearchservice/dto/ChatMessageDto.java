package com.example.elasticsearchservice.dto;

import com.example.elasticsearchservice.model.ChatMessage;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class ChatMessageDto {

    @NotBlank
    private String id;

    @NotBlank
    private String message;

    @NotBlank
    private String sender;

    @NotBlank
    private String roomId;

    @NotBlank
    private String roomName;

    public ChatMessage toDocument() {
        return ChatMessage.builder()
                .id(this.getId())
                .message(this.getMessage())
                .sender(this.getSender())
                .roomId(this.getRoomId())
                .roomName(this.getRoomName())
                .build();
    }
}
