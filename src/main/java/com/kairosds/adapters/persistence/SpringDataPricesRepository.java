package com.kairosds.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SpringDataPricesRepository extends JpaRepository<PriceJpaEntity, Long> {
    List<PriceJpaEntity> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            long productId, long brandId, LocalDateTime startDate, LocalDateTime endDate);
}
