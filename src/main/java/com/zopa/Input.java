package com.zopa;

import com.zopa.service.AmortizationServiceImpl;
import com.zopa.validator.InputValidator;

public class Input {

    public static void main(String[] args) {

        InputValidator.execute(args);

        new AmortizationServiceImpl().execute(args[0]);

    }
}
