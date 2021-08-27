package com.zopa.repository;

import com.opencsv.bean.CsvToBeanBuilder;
import com.zopa.model.Lender;
import com.zopa.repository.validator.LenderValidator;
import com.zopa.utils.FileUtils;
import com.zopa.validator.InputValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LenderRepositoryImpl implements LenderRepository {

    public List<Lender> findLendersSortedByMinRate() {

        List<Lender> lenders = new CsvToBeanBuilder<Lender>(FileUtils.readFile())
                .withType(Lender.class)
                .build()
                .parse();

        lenders.sort(Comparator.comparing(Lender::getRate));

        return lenders;
    }

    public List<Lender> findBestLenders(int loanAmount, List<Lender> lenders) {

        LenderValidator.assertValidTotalLendersOffer(loanAmount, lenders);

        int counterAmount = 0;
        List<Lender> bestLenders = new ArrayList<>();

        for (Lender lender : lenders) {
            counterAmount += lender.getAvailable();
            bestLenders.add(lender);
            if (counterAmount >= loanAmount){
                break;
            }
        }
        return bestLenders;
    }
}
