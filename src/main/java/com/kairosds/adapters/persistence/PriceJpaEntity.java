package com.kairosds.adapters.persistence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ApiModel(description = "Entity for product prices over time")
@Table(name = "Prices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter long priceId;

    @ApiModelProperty(notes = "Store group foreign key (1 = ZARA)")
    private @Getter long brandId;
    @ApiModelProperty(notes = "Date when the price starts to apply for the product")
    private @Getter LocalDateTime startDate;
    @ApiModelProperty(notes = "Date when the price ends to apply for the product")
    private @Getter LocalDateTime endDate;
    @ApiModelProperty(notes = "Applied fare id")
    private @Getter long priceList;
    @ApiModelProperty(notes = "Product code id")
    private @Getter long productId;
    @ApiModelProperty(notes = "Tiebreaker. If two fares applies at the same time the one with more priority is selected (numeric)")
    private @Getter int priority;
    @ApiModelProperty(notes = "Final price")
    private @Getter float price;
    @ApiModelProperty(notes = "Currency ISO")
    private @Getter String curr;
}
