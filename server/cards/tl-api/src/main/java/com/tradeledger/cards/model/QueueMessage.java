package com.tradeledger.cards.model;


import com.tradeledger.cards.dto.Applicant;
import com.tradeledger.cards.dto.EligibilityResponse;
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
