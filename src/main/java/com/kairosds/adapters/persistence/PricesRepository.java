package com.kairosds.adapters.persistence;

import com.kairosds.application.domain.Price;
import com.kairosds.application.domain.PriceList;
import com.kairosds.application.port.outgoing.LoadPricesPort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PricesRepository implements LoadPricesPort {
    private SpringDataPricesRepository repository;

    public PricesRepository(SpringDataPricesRepository repository) {
        this.repository = repository;
    }

    @Override
    public PriceList load(long productId, long brandId, LocalDateTime date) {

        List<PriceJpaEntity> prices = repository.findAll();

        return new PriceList(mapToDomainEntity(prices));
    }

    private List<Price> mapToDomainEntity(List<PriceJpaEntity> prices) {
        List<Price> mappedPrices = new ArrayList<>();

        for (PriceJpaEntity price : prices) {
            mappedPrices.add(new Price(
                    price.getPriceId(),
                    price.getBrandId(),
                    price.getStartDate(),
                    price.getEndDate(),
                    price.getPriceList(),
                    price.getProductId(),
                    price.getPriority(),
                    price.getPrice(),
                    price.getCurr()
            ));
        }

        return mappedPrices;
    }

}
