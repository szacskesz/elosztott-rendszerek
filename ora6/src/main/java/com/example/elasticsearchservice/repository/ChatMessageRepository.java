package com.example.elasticsearchservice.repository;

import com.example.elasticsearchservice.model.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ChatMessageRepository extends ElasticsearchRepository<ChatMessage, String> {

    Page<ChatMessage> findBySender(String sender, Pageable pageable);

    Page<ChatMessage> findByMessage(String message, Pageable pageable);
}
