package com.tradeledger.cards.eligibility.util;


import com.tradeledger.cards.eligibility.dto.Applicant;
import com.tradeledger.cards.eligibility.dto.EligibilityResponse;
import com.tradeledger.cards.eligibility.model.QueueMessage;

import java.util.HashSet;
import java.util.Set;

public class TestData {

    public static EligibilityResponse getEligibilityResponse(){
        EligibilityResponse expectedEligibilityResponse = new EligibilityResponse();
        Set<String> cards = new HashSet<>();
        cards.add("C1");
        expectedEligibilityResponse.setEligibleCards(cards);
        return expectedEligibilityResponse;
    }

    public static Applicant getApplicant(){
        Applicant applicant = new Applicant("Boris", "Boris@bbc.com","12 Whitechapel Road");
        return applicant;
    }
    public static QueueMessage getQueueMessage(){
        return new QueueMessage(getApplicant(), getEligibilityResponse());
    }

}
