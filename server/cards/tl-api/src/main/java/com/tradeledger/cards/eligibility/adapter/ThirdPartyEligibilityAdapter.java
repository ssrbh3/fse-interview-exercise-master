package com.tradeledger.cards.eligibility.adapter;

import com.tradeledger.cards.eligibility.dto.Applicant;
import com.tradeledger.cards.eligibility.dto.EligibilityResponse;

public interface ThirdPartyEligibilityAdapter {
    EligibilityResponse getEligibility(Applicant applicant);
}
