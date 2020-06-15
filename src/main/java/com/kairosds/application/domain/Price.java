package com.kairosds.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Price {
    private @Getter long priceId;
    private @Getter long brandId;
    private @Getter LocalDateTime startDate;
    private @Getter LocalDateTime endDate;
    private @Getter long priceList;
    private @Getter long productId;
    private @Getter int priority;
    private @Getter float price;
    private String curr;

}
