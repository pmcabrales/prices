package com.kairosds.application.domain;

import com.kairosds.adapters.utils.DatesUtil;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class PriceListTest {
    @Test
    public void ifThereAreMoreThanOneFareAppliesOneWithMaxPriority() {
        LocalDateTime startDate = DatesUtil.dateFormat("2020-06-14-10.00.00");
        LocalDateTime endDate = DatesUtil.dateFormat("2020-10-14-10.00.00");

        List<Price> prices = new ArrayList<>();
        prices.add(new Price(1,1,startDate,endDate,1,1,5,100,"EUR"));
        prices.add(new Price(2,1,startDate,endDate,1,1,15,115,"EUR"));
        prices.add(new Price(3,1,startDate,endDate,1,1,10,225,"EUR"));

        PriceList priceList = new PriceList(prices);
        Price price = priceList.getPriceToApply(1,1,DatesUtil.dateFormat("2020-08-14-10.00.00"));

        assertEquals(price.getPriceId(),2);
    }

    @Test
    public void ifThereAreNotAnyFareThrowsNoSuchElementException() {
        List<Price> prices = new ArrayList<>();
        PriceList priceList = new PriceList(prices);

        boolean isThrown = false;
        try {
            Price price = priceList.getPriceToApply(1, 1, DatesUtil.dateFormat("2020-08-14-10.00.00"));
        }catch (NoSuchElementException ex){
            isThrown = true;
        }

        assertEquals(true,isThrown);
    }

}
