package com.kairosds.application.port.outgoing;

import com.kairosds.application.domain.PriceList;

import java.time.LocalDateTime;

public interface LoadPricesPort {
    PriceList load(long productId, long brandId, LocalDateTime date);
}
