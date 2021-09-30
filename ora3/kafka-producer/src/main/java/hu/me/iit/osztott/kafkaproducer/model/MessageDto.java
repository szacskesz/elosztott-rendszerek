package hu.me.iit.osztott.kafkaproducer.model;

import lombok.Data;

@Data
public class MessageDto {
	private String message;
	private String from;
	private String room;
}
