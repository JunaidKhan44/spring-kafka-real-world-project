package com.jk.springboot;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * @author Junaid.Khan
 *
 */

@Service
public class WikimediaChangesProducer {

    private static  final Logger LOGGER =
            LoggerFactory.getLogger(WikimediaChangesProducer.class);

    private KafkaTemplate<String,String>  kafkaTemplate;

    // if spring bean has single constructor than don't need to add @Autowired
    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage() throws InterruptedException {

        String topic = "wikimedia_recentchange";

        // to read real time stream data from wikimedia, we use event source

        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate,topic);
        String url="https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder= new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource=builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);


    }
}
