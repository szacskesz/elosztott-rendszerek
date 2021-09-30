package hu.me.iit.osztott.kafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import hu.me.iit.osztott.kafkaproducer.model.MessageDto;

public interface KafkaService {

	void sendMessage(MessageDto messageDto) throws JsonProcessingException;
}
