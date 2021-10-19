package com.example.elasticsearchservice.controller;

import com.example.elasticsearchservice.dto.ChatMessageDto;
import com.example.elasticsearchservice.dto.FindByDto;
import com.example.elasticsearchservice.model.ChatMessage;
import com.example.elasticsearchservice.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatMessageRepository chatMessageRepository;

    @PostMapping(path = "", consumes = "application/json")
    public void newData(@RequestBody @Valid ChatMessageDto chatMessageDto) {
        chatMessageRepository.save(chatMessageDto.toDocument());
    }

    @GetMapping(path = "", consumes = "application/json")
    public Page<ChatMessage> findMessageBySender(@RequestBody @Valid FindByDto senderDto) {
        return chatMessageRepository.findBySender(
                senderDto.getQuery(),
                PageRequest.of(0, 10)
        );
    }

    @GetMapping(path = "by-message",consumes = "application/json")
    public Page<ChatMessage> findMessageByMessage(@RequestBody @Valid FindByDto senderDto) {
        return chatMessageRepository.findByMessage(
                senderDto.getQuery(),
                PageRequest.of(0, 10)
        );
    }
}
