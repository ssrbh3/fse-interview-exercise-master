package com.tradeledger.cards.eligibility.service;

import com.tradeledger.cards.eligibility.model.QueueMessage;
import org.springframework.scheduling.annotation.Async;

public interface QueueService {
     @Async
     void pushMessage(QueueMessage queueMessage);
     void retry();
}
