package com.Query.query;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;



@SpringBootApplication
@EnableWebSocket
@EnableWebSocketMessageBroker
public class QueryApplication {



	public static void main(String[] args) throws InterruptedException {
	  SpringApplication.run(QueryApplication.class, args);
	}

}
