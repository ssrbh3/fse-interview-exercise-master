package com.tradeledger.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EligibilityException extends RuntimeException {
    public EligibilityException(String message) {
        super(message);
    }
}
