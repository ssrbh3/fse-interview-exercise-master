package com.tradeledger.cards.service;


import com.tradeledger.cards.dto.Applicant;
import com.tradeledger.cards.dto.EligibilityResponse;

public interface CardEligibilityService {
    EligibilityResponse eligibilityService(Applicant applicant);
}
