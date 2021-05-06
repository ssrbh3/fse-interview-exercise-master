package com.tradeledger.cards.service;


import com.tradeledger.cards.adapter.ThirdPartyEligibilityAdapter;
import com.tradeledger.cards.dto.Applicant;
import com.tradeledger.cards.dto.EligibilityResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Card Eligibility service
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class CardEligibilityServiceImpl implements CardEligibilityService {

    private final ThirdPartyEligibilityAdapter thirdPartyEligibilityAdapter;
    private final QueueService queueService;
    private final QueueMessageResponseService queueMessageResponseService;

    /**
     * check eligibility by calling third party API and also build a Queue Msg response
     * to save that in a queue for us to process and store in DB later on
     *
     */
    @Override
    public EligibilityResponse eligibilityService(Applicant applicant){
        EligibilityResponse eligibilityResponse = checkEligibility(applicant);
        queueService.pushMessage(queueMessageResponseService.createQueueResponse(applicant,eligibilityResponse));
        return eligibilityResponse;
    }

    /**
     * Call to third party API using adapter class
     */
    private EligibilityResponse checkEligibility(Applicant applicant) {
        return thirdPartyEligibilityAdapter.getEligibility(applicant);
    }

}
