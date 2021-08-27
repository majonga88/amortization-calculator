package com.zopa.repository;

import com.zopa.model.Lender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.stefanbirkner.systemlambda.SystemLambda.catchSystemExit;

class LenderRepositoryImplTest {

    @Test
    void findLendersSortedByMinRate() {

        List<Lender> lendersSortedByMinRate = new LenderRepositoryImpl().findLendersSortedByMinRate();

        Assertions.assertEquals(7, lendersSortedByMinRate.size());
        Assertions.assertEquals(0.069, lendersSortedByMinRate.get(0).getRate());
        Assertions.assertEquals(0.104, lendersSortedByMinRate.get(6).getRate());
    }

    @Test
    void findBestLenders() throws Exception {

        List<Lender> lendersSortedByMinRate = new LenderRepositoryImpl().findLendersSortedByMinRate();

        int statusCode = catchSystemExit(() -> {
            new LenderRepositoryImpl().findBestLenders(600, List.of(lendersSortedByMinRate.get(0)));
        });
        Assertions.assertEquals(0, statusCode);

        List<Lender> bestLenders = new LenderRepositoryImpl().findBestLenders(1100, lendersSortedByMinRate);

        Assertions.assertEquals(4, bestLenders.size());
        Assertions.assertEquals(0.069, bestLenders.get(0).getRate());
        Assertions.assertEquals(0.074, bestLenders.get(3).getRate());

        bestLenders = new LenderRepositoryImpl().findBestLenders(1700, lendersSortedByMinRate);

        Assertions.assertEquals(5, bestLenders.size());
        Assertions.assertEquals(0.069, bestLenders.get(0).getRate());
        Assertions.assertEquals(0.075, bestLenders.get(4).getRate());
    }
}