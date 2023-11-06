package ru.fastdelivery.usecase;

import ru.fastdelivery.domain.common.price.Price;

public record CalculatedShipmentPrice(
        Price totalPrice,
        Price minimalPrice
) {
}
