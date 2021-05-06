package com.tradeledger.cards.service;

import com.tradeledger.cards.model.QueueMessage;
import org.springframework.scheduling.annotation.Async;

public interface QueueService {
     @Async
     void pushMessage(QueueMessage queueMessage);
     void retry();
}
