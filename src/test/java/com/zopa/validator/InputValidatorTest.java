package com.zopa.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.catchSystemExit;

class InputValidatorTest {

    @Test
    void assertValidInput() throws Exception {

        int statusCode = catchSystemExit(() -> {
            String[] args = new String[]{""};
            InputValidator.assertValidInput(args);
        });
        Assertions.assertEquals(0, statusCode);

        statusCode = catchSystemExit(() -> {
            String[] args = new String[]{"AAAA"};
            InputValidator.assertValidInput(args);
        });
        Assertions.assertEquals(0, statusCode);

        statusCode = catchSystemExit(() -> {
            String[] args = new String[]{"AAAA", "111"};
            InputValidator.assertValidInput(args);
        });
        Assertions.assertEquals(0, statusCode);
    }

    @Test
    void assertValidLoan() throws Exception {

        int statusCode = catchSystemExit(() -> {
            String[] args = new String[]{"12345"};
            InputValidator.assertValidLoan(args);
        });
        Assertions.assertEquals(0, statusCode);

        statusCode = catchSystemExit(() -> {
            String[] args = new String[]{"222"};
            InputValidator.assertValidLoan(args);
        });
        Assertions.assertEquals(0, statusCode);

        String[] args = new String[]{"1200"};
        InputValidator.assertValidInput(args);
    }
}