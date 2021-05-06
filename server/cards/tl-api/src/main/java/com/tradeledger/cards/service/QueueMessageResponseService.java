package com.tradeledger.cards.service;

import com.tradeledger.cards.dto.Applicant;
import com.tradeledger.cards.dto.EligibilityResponse;
import com.tradeledger.cards.model.QueueMessage;

public interface QueueMessageResponseService {
    QueueMessage createQueueResponse(Applicant applicant, EligibilityResponse eligibilityResponse);
}
