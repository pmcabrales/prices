package com.kairosds.application.domain;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class PriceList {
    List<Price> prices;

    public PriceList(List<Price> prices) {
        this.prices = prices;
    }

    public Price getPriceToApply (long productId, long brandId, LocalDateTime date){
        return prices.stream()
                .filter(c -> c.getProductId() == productId
                        && c.getBrandId() == brandId
                        && c.getStartDate().isBefore(date)
                        && c.getEndDate().isAfter(date))
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(NoSuchElementException::new);
    }

}
