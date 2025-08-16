package com.winnerx0.document_parser.service;

import com.winnerx0.document_parser.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    // picks up teh messages that are sent to this queue
    @RabbitListener(queues = RabbitmqConfig.QUEUE)
    public void documentParser(String in) throws InterruptedException {

        Thread.sleep(60000);
        System.out.println("response " + in);

    }
}
