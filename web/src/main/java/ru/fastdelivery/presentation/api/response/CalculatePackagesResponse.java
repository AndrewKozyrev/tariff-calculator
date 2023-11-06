package ru.fastdelivery.presentation.api.response;

import ru.fastdelivery.usecase.CalculatedShipmentPrice;

import java.math.BigDecimal;

public record CalculatePackagesResponse(
        BigDecimal totalPrice,
        BigDecimal minimalPrice,
        String currencyCode
) {
    public CalculatePackagesResponse(CalculatedShipmentPrice prices) {
        this(prices.totalPrice().amount(),
                prices.minimalPrice().amount(),
                prices.totalPrice().currency().getCode());

        if (currencyIsNotEqual(prices)) {
            throw new IllegalArgumentException("Currency codes must be the same");
        }
    }

    private static boolean currencyIsNotEqual(CalculatedShipmentPrice prices) {
        return !prices.totalPrice().currency().equals(prices.minimalPrice().currency());
    }
}
