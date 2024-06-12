package com.jk.springboot;


import com.jk.springboot.entity.WikiMediaModel;
import com.jk.springboot.repository.WikiMediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author Junaid.Khan
 *
 */

@Service
public class KafkaDataBaseConsumer {


    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaDataBaseConsumer.class);

    private WikiMediaRepository dataRepo;

    public KafkaDataBaseConsumer(WikiMediaRepository dataRepo) {
        this.dataRepo = dataRepo;
    }

    @KafkaListener(topics="wikimedia_recentchange",groupId="myGroup")
    public void consume(String eventMessage){

        LOGGER.info(String.format("Event Message received ->%s",eventMessage));

        WikiMediaModel model = new WikiMediaModel();
        model.setWikiEventData(eventMessage);

        dataRepo.save(model);

    }

}
