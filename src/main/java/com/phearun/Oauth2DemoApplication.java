package com.phearun;

import com.phearun.model.Message;
import com.phearun.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@SpringBootApplication
public class Oauth2DemoApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(Oauth2DemoApplication.class, args);
	}

	@Autowired
	MessageRepository messageRepository;

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		Arrays.asList(
				new Message("Hello!"),
				new Message("Hello World!")
		).stream().forEach(message -> messageRepository.save(message));

	}
}
