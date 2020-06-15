package com.kairosds.application.services;

import com.kairosds.application.domain.Price;
import com.kairosds.application.domain.PriceList;
import com.kairosds.application.port.incoming.GetCurrentPriceUseCase;
import com.kairosds.application.port.outgoing.LoadPricesPort;

import java.time.LocalDateTime;

public class PricesService implements GetCurrentPriceUseCase {
    private LoadPricesPort loadPricesPort;

    public PricesService(LoadPricesPort loadPricesPort) {
        this.loadPricesPort = loadPricesPort;
    }

    @Override
    public Price get(long productId, long brandId, LocalDateTime date) {
        PriceList prices = loadPricesPort.load(productId, brandId, date);

        return prices.getPriceToApply(productId,brandId,date);
    }

}
