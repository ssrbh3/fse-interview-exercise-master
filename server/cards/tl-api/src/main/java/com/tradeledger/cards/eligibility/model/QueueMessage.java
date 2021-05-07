package com.tradeledger.cards.eligibility.model;


import com.tradeledger.cards.eligibility.dto.Applicant;
import com.tradeledger.cards.eligibility.dto.EligibilityResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class QueueMessage {
    private Applicant applicant;
    private EligibilityResponse eligibilityResponse;

}
