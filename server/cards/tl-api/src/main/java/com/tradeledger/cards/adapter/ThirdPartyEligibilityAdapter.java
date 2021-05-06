package com.tradeledger.cards.adapter;

import com.tradeledger.cards.dto.Applicant;
import com.tradeledger.cards.dto.EligibilityResponse;

public interface ThirdPartyEligibilityAdapter {
    EligibilityResponse getEligibility(Applicant applicant);
}
