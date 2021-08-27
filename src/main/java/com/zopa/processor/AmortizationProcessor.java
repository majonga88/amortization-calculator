package com.zopa.processor;

import com.zopa.model.Lender;

import java.util.List;

public interface AmortizationProcessor {

    double averageInterestRate(List<Lender> lenders);

    double monthlyPayment(double loanAmount, double averageRateInterest);

    double totalLoanReimbursement(double monthlyPayment);

}
