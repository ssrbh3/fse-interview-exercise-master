package com.tradeledger.cards.eligibility.service;

import com.tradeledger.cards.eligibility.dto.Applicant;
import com.tradeledger.cards.eligibility.dto.EligibilityResponse;
import com.tradeledger.cards.eligibility.model.QueueMessage;

public interface QueueMessageResponseService {
    QueueMessage createQueueResponse(Applicant applicant, EligibilityResponse eligibilityResponse);
}
