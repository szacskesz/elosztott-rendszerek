package hu.me.iit.osztott.kafkaproducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import hu.me.iit.osztott.kafkaproducer.model.MessageDto;
import hu.me.iit.osztott.kafkaproducer.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
	
	private final KafkaService kafkaService;

	@PostMapping("/send-message")
	void main(@RequestBody MessageDto message) throws JsonProcessingException {
		kafkaService.sendMessage(message);
	}
}
