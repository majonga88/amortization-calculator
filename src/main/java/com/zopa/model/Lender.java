package com.zopa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lender {

    private String lender;
    private double rate;
    private int available;
}
