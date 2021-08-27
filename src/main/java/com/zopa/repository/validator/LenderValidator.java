package com.zopa.repository.validator;

import com.zopa.model.Lender;

import java.util.List;

public class LenderValidator {

    public static void assertValidTotalLendersOffer(int loanAmount, List<Lender> lenders) {

        double totalLendersOffer = lenders.stream().mapToDouble(Lender::getAvailable).sum();

        if(loanAmount > totalLendersOffer) {
            System.out.println("The market does not have enough offers to fulfil the request.");
            System.exit(0);
        }
    }
}
