package com.tradeledger.cards.eligibility.service;

import com.tradeledger.cards.eligibility.dto.Applicant;
import com.tradeledger.cards.eligibility.dto.EligibilityResponse;
import com.tradeledger.cards.eligibility.model.QueueMessage;
import org.springframework.stereotype.Service;

/**
 * Service class to build response , there is not a lot of service logic here. But it makes more
 * sense to keep a separate service class rather then cluttering existing service class, This way we can keep one class one responsibility.
 */
@Service
public class QueueMessageResponseServiceServiceImpl implements QueueMessageResponseService {
    @Override
    public QueueMessage createQueueResponse(Applicant applicant, EligibilityResponse eligibilityResponse) {
        return new QueueMessage(applicant,eligibilityResponse);
    }
}
