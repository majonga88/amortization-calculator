package com.zopa.processor;

import com.zopa.model.Lender;

import java.util.List;
import java.util.NoSuchElementException;

public class AmortizationProcessorImpl {

    public static final int LOAN_MONTHS = 36;

    public double averageInterestRate(List<Lender> lenders) {
        return lenders.stream()
                .mapToDouble(Lender::getRate)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public double monthlyPayment(double loanAmount, double averageRateInterest) {

        double monthlyAverageInterestRate = averageRateInterest / 12;
        return loanAmount * monthlyAverageInterestRate /
                ( 1 - 1 / Math.pow(1 + monthlyAverageInterestRate, LOAN_MONTHS) );
    }

    public double totalLoanReimbursement(double monthlyPayment) {

        return monthlyPayment * LOAN_MONTHS;
    }
}
