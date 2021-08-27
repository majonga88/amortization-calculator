package com.zopa.validator;

import org.apache.commons.lang3.StringUtils;

public class InputValidator {

    private static final int MIN_QUOTE = 1000;
    private static final int MAX_QUOTE = 15000;
    private static final int QUOTE_INCREMENT = 100;

    public static void execute(String[] args) {
        assertValidInput(args);
        assertValidLoan(args);
    }

    public static void assertValidInput(String[] args) {
        if(args.length != 1) {
            System.out.println("Wrong number of parameters to launch the program.");
            System.exit(0);
        }
        if (args[0] == null || "".equals(args[0])) {
            System.out.println("Loan amount is mandatory to launch the program.");
            System.exit(0);
        }
        if (!StringUtils.isNumeric(args[0])) {
            System.out.println("Loan amount must be numeric.");
            System.exit(0);
        }
    }

    public static void assertValidLoan(String[] args) {
        int loan = Integer.parseInt(args[0]);
        if (loan < MIN_QUOTE || loan > MAX_QUOTE || loan % QUOTE_INCREMENT != 0) {
            System.out.println("Loan input requested invalid, it must be any £100 increment between £1000 and £15000 inclusive");
            System.exit(0);
        }
    }
}
