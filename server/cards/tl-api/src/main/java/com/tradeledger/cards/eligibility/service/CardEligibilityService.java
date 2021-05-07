package com.tradeledger.cards.eligibility.service;


import com.tradeledger.cards.eligibility.dto.Applicant;
import com.tradeledger.cards.eligibility.dto.EligibilityResponse;

public interface CardEligibilityService {
    EligibilityResponse eligibilityService(Applicant applicant);
}
