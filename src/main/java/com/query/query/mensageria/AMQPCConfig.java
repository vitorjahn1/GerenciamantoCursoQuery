package com.query.query.mensageria;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class AMQPCConfig {
	
	  public static final String ROUTING_KEY = "route";

	    static final String topicExchangeName = "Aluno";

	    static final String queueName = "aluno";
    
	  @Autowired
	    

	    @Bean
	    Queue queue() {
	        return new Queue(queueName, false);
	    }

	    @Bean
	    TopicExchange exchange() {
	        return new TopicExchange(topicExchangeName);
	    }

	    /*@Bean
	    DirectExchange exchange() {
	        return new DirectExchange(rabbitMQProperties().getExchangeName());
	    }*/

	    @Bean
	    Binding binding(Queue queue, TopicExchange exchange) {
	        return BindingBuilder.bind(queue).to(exchange).with("route");
	    }

	    @Bean
	    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	                                             MessageListenerAdapter listenerAdapter) {
	        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	        container.setConnectionFactory(connectionFactory);
	        container.setQueueNames(queueName);
	        container.setMessageListener(listenerAdapter);
	        return container;
	    }

	    @Bean
	    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
	        return new MappingJackson2MessageConverter();
	    }

	    @Bean
	    public RabbitTemplate amqpTemplate(ConnectionFactory connectionFactory) {
	        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(messageConverter());
	        return rabbitTemplate;
	    }

	    @Bean
	    public Jackson2JsonMessageConverter messageConverter() {
	        return new Jackson2JsonMessageConverter();
	    }

	    @Bean
	    public MessageListenerAdapter messageListenerAdapter() {
	        MessageListenerAdapter listener =  new MessageListenerAdapter();
	        return listener;
	    }



 

}
