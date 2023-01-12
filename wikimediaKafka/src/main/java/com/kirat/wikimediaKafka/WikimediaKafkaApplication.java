package com.kirat.wikimediaKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikimediaKafkaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WikimediaKafkaApplication.class, args);
	}
	
	@Autowired
	private WikimediaChangesProducer changesProducer;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		changesProducer.sendMessage();
	}

}
