package com.tradeledger.cards.eligibility.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class EligibilityResponse {
    private Set<String> eligibleCards;
}
