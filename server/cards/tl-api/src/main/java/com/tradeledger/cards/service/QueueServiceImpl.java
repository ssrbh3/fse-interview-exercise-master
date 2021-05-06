package com.tradeledger.cards.service;

import com.tradeledger.cards.model.QueueMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * CardService to save request and response to a queue asynchronously with retry mechanism to handle
 * fault.
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class QueueServiceImpl implements QueueService {
    private final List<QueueMessage> deadQueue = new LinkedList<>();

    /**
     * Usual push mechanism to push messages in a queue which could be consumed
     * by listeners to persist in an DB (check attached design doc for more details), this method is async
     * as we do not want user to keep waiting , also because this is something
     * TL will use.
     *
     */
    @Async
    @Override
    public void pushMessage(QueueMessage queueMessage) {
        try {
            //Push message to a queue - Queue settings Rabbit/Kafka - then this could be
            //used by listeners to persist the data into DB
            Thread.sleep(50);
            log.info("message queued {} ", queueMessage);
        } catch (Exception e) {
            log.error("Error {} , queueMessage {} ", e, queueMessage);
            deadQueue.add(queueMessage);
        }
    }

    /*
     * Fault tolerance mechanism
     *
     Schedule based retry mechanism, it uses FIFO to publish,
     * those jobs which published successfully will remove naturally,
     * but in case of failure those jobs will requeue again.
     *
     * taking 30 mins as an example this needs to be agreed.
     */

    // check and run only when deadQ is not empty
    @Override
    @Scheduled(fixedDelay = 300000)
    public void retry() {
        log.info("Retrying Message push if there are any failure in queueing ");
        if (!deadQueue.isEmpty()) {
            log.info("Retrying Message push if there are any failure in queueing ");
            final List<QueueMessage> temp = new LinkedList<>(deadQueue);
            deadQueue.clear();
            Collections.reverse(temp);
            temp.forEach(this::pushMessage);
        }

    }

}
