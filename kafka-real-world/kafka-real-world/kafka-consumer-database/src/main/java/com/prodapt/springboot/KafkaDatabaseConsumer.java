package com.prodapt.springboot;

import com.prodapt.springboot.entity.WikimediaData;
import com.prodapt.springboot.repository.WikimediaDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaDatabaseConsumer {


    @Autowired
    private WikimediaDataRepository repository;

    @KafkaListener(topics = "${spring.kafka.topic.name}",
                        groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage){

        log.info(String.format("Event message received :--------->%s",eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        repository.save(wikimediaData);
    }
}
