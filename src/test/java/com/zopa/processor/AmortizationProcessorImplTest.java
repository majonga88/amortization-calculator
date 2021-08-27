package com.zopa.processor;

import com.zopa.model.Lender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

class AmortizationProcessorImplTest {

    @Test
    void averageInterestRate() {

        List<Lender> lenders = List.of(
                Lender.builder().lender("Jane").rate(0.069f).available(480).build(),
                Lender.builder().lender("Fred").rate(0.071f).available(520).build());

        double averageInterestRate = new AmortizationProcessorImpl().averageInterestRate(lenders);

        Assertions.assertEquals(0.07000000029802322, averageInterestRate);

        lenders = List.of(
                Lender.builder().lender("Bob").rate(0.075f).available(640).build(),
                Lender.builder().lender("Jane").rate(0.069f).available(480).build(),
                Lender.builder().lender("Fred").rate(0.071f).available(520).build(),
                Lender.builder().lender("Mary").rate(0.104f).available(170).build(),
                Lender.builder().lender("John").rate(0.081f).available(320).build(),
                Lender.builder().lender("Dave").rate(0.074f).available(140).build(),
                Lender.builder().lender("Angela").rate(0.071f).available(60).build());

        averageInterestRate = new AmortizationProcessorImpl().averageInterestRate(lenders);

        Assertions.assertEquals(0.07785714417695999, averageInterestRate);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            new AmortizationProcessorImpl().averageInterestRate(Collections.emptyList());
        });
    }

    @Test
    void monthlyPayment() {

        double loanAmount = 1700;
        double averageRateInterest = 0.072;

        double monthlyPayment = new AmortizationProcessorImpl().monthlyPayment(loanAmount, averageRateInterest);

        Assertions.assertEquals(52.64665770361426, monthlyPayment);

        loanAmount = 1000;
        averageRateInterest = 0.070;

        monthlyPayment = new AmortizationProcessorImpl().monthlyPayment(loanAmount, averageRateInterest);

        Assertions.assertEquals(30.87709686537184, monthlyPayment);
    }

    @Test
    void totalLoanReimbursement() {

        double totalLoanReimbursement = new AmortizationProcessorImpl().totalLoanReimbursement(30.87709686537184);

        Assertions.assertEquals(1111.5754871533863, totalLoanReimbursement);

        totalLoanReimbursement = new AmortizationProcessorImpl().totalLoanReimbursement(52.64665770361426);

        Assertions.assertEquals(1895.2796773301134, totalLoanReimbursement);
    }
}