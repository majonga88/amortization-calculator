package com.zopa.repository;

import com.opencsv.bean.CsvToBeanBuilder;
import com.zopa.model.Lender;
import com.zopa.utils.FileUtils;

import java.util.List;

public interface LenderRepository {

    List<Lender> findLendersSortedByMinRate();

    List<Lender> findBestLenders(int loanAmount, List<Lender> lenders);
}
