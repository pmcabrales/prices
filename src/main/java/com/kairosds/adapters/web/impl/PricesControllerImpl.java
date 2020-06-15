package com.kairosds.adapters.web.impl;

import com.kairosds.adapters.utils.DatesUtil;
import com.kairosds.adapters.web.PricesController;
import com.kairosds.application.domain.Price;
import com.kairosds.application.port.incoming.GetCurrentPriceUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricesControllerImpl implements PricesController {

    private final GetCurrentPriceUseCase getCurrentPriceUseCase;

    public PricesControllerImpl(GetCurrentPriceUseCase getCurrentPriceUseCase) {
        this.getCurrentPriceUseCase = getCurrentPriceUseCase;
    }

    @GetMapping("/prices")
    @ResponseStatus(HttpStatus.OK)
    public Price getProductPrice(@RequestParam String date, @RequestParam long productId, @RequestParam long brandId){
        return getCurrentPriceUseCase.get(productId,brandId, DatesUtil.dateFormat(date));
     }

}
