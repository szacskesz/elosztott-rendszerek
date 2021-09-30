package hu.me.iit.osztott.kafkaproducer.config;

import hu.me.iit.osztott.kafkaproducer.util.TopicConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder
			.name(TopicConstants.CHAT_ROOM)
			.partitions(1)
			.replicas(1)
			.build();
    }
}
