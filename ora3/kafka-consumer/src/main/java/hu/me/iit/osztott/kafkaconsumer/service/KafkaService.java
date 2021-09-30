package hu.me.iit.osztott.kafkaconsumer.service;

import hu.me.iit.osztott.kafkaconsumer.util.TopicConstants;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	@KafkaListener(topics = TopicConstants.CHAT_ROOM)
	void listen(ConsumerRecord<Long, String> message) {
		System.out.println(message.value());
	}
}
