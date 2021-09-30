package hu.me.iit.osztott.kafkaproducer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.me.iit.osztott.kafkaproducer.model.MessageDto;
import hu.me.iit.osztott.kafkaproducer.util.TopicConstants;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@RequiredArgsConstructor
public class KafkaService implements hu.me.iit.osztott.kafkaproducer.service.KafkaService {
	
	private final KafkaTemplate<Long, String> kafkaTemplate;
	private final ObjectMapper objectMapper;

	@Override
	public void sendMessage(MessageDto messageDto) throws JsonProcessingException {
		String message = objectMapper.writeValueAsString(messageDto);
		Long key = 0L;
		
		ProducerRecord<Long, String> producerRecord = buildProducerRecord(key, message, TopicConstants.CHAT_ROOM);
		ListenableFuture<SendResult<Long, String>> sendResult$ = kafkaTemplate.send(producerRecord);

		sendResult$.addCallback(
				(result) -> {
					System.out.printf("Success message %s%n", result.toString());
				},
				(error) -> {
					System.out.printf("Failed message %s%n", error.toString());
				}
		);
	}
	
	private ProducerRecord<Long, String> buildProducerRecord(Long key, String value, String topic) {
		return new ProducerRecord<Long, String>(topic, null, key, value, null);
	}
}
