package com.rabbitmq.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PublisherApplication {

	@Value("${queue.name}")
	String queueName;
	
	@Autowired
	private RabbitTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public void sendMesage() {
		String a = "Message sent to listener";
		this.template.convertAndSend(queueName, a);
	}
}
