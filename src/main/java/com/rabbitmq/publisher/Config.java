package com.rabbitmq.publisher;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
	
	@Value("${queue.name}")
	String queueName;
	
	@Value("${spring.application.name}")
	String appName;

	private final ConnectionFactory connectionFactory;

	@Autowired
	    public Config(ConnectionFactory connectionFactory){
	        this.connectionFactory = connectionFactory;
	    }

	@Bean
	public RabbitTemplate template() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(this.connectionFactory);
		rabbitTemplate.setQueue(queueName);
		rabbitTemplate.setRoutingKey(queueName);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		return rabbitTemplate;
	}
	
	@Bean
	public Queue queue() {
		return new Queue(queueName, true);
	}
	
	@Bean
	DirectExchange exchange() {
		String exchange = appName.concat("Exchange");
		return new DirectExchange(exchange);
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		String queueName = appName.concat("Queue");
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}

	@Bean
	AmqpAdmin amqpAdmin() {
		RabbitAdmin admin = new RabbitAdmin(connectionFactory);
		admin.declareQueue(queue());
		admin.declareExchange(exchange());
		admin.declareBinding(binding(queue(), exchange()));
		return admin;
	}
	


}
