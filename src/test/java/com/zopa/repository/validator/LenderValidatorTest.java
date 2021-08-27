package com.zopa.repository.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static com.github.stefanbirkner.systemlambda.SystemLambda.catchSystemExit;

class LenderValidatorTest {

    @Test
    void assertValidTotalLendersOffer() throws Exception {

        int statusCode = catchSystemExit(() -> {
            LenderValidator.assertValidTotalLendersOffer(1, Collections.emptyList());
        });
        Assertions.assertEquals(0, statusCode);
    }
}