package com.kairosds.application.port.incoming;

import com.kairosds.application.domain.Price;

import java.time.LocalDateTime;

public interface GetCurrentPriceUseCase {
    Price get(long productId, long brandId, LocalDateTime date);
}
