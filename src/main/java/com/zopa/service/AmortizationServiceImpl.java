package com.zopa.service;

import com.zopa.model.Lender;
import com.zopa.processor.AmortizationProcessorImpl;
import com.zopa.repository.LenderRepositoryImpl;

import java.util.List;

public class AmortizationServiceImpl {

    public void execute(String loanAmountStr) {

        int loanAmount = Integer.parseInt(loanAmountStr);

        List<Lender> lenders = new LenderRepositoryImpl().findLendersSortedByMinRate();
        List<Lender> bestLenders = new LenderRepositoryImpl().findBestLenders(loanAmount, lenders);

        double averageAnnualInterestRate = new AmortizationProcessorImpl().averageInterestRate(bestLenders);
        double monthlyPayment = new AmortizationProcessorImpl().monthlyPayment(loanAmount, averageAnnualInterestRate);
        double totalLoanReimbursement = new AmortizationProcessorImpl().totalLoanReimbursement(monthlyPayment);

        System.out.println("Requested amount:" + loanAmount);
        System.out.println("Annual Interest Rate:" + String.format("%.1f", averageAnnualInterestRate * 100) + "%");
        System.out.println("Monthly repayment:£" + String.format("%.2f", monthlyPayment));
        System.out.println("Total repayment:£" + String.format("%.2f", totalLoanReimbursement));
    }

}
