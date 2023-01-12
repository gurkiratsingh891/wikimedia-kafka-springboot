package com.kirat.wikimedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kirat.wikimedia.entity.WikimediaData;
import com.kirat.wikimedia.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	private WikimediaDataRepository dataRepository;
	
	public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository)
	{
		this.dataRepository = dataRepository;
	}
	
	@KafkaListener(
		topics = "${spring.kafka.topic.name}",
		groupId = "${spring.kafka.consumer.group-id}"
	)
	public void consume(String eventMessage)
	{
		LOGGER.info(String.format("Event message received -> %s", eventMessage));
		
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage.substring(0,50));		
		dataRepository.save(wikimediaData);
	}
}
