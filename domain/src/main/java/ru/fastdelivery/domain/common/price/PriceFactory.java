package ru.fastdelivery.domain.common.price;

import lombok.RequiredArgsConstructor;
import ru.fastdelivery.domain.common.currency.Currency;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class PriceFactory {

    public Price create(BigDecimal amount, Currency currency) {
        if (isLessThanZero(amount)) {
            throw new IllegalArgumentException("Price Amount cannot be below Zero!");
        }
        
        return new Price(amount, currency);
    }

    private static boolean isLessThanZero(BigDecimal price) {
        return BigDecimal.ZERO.compareTo(price) > 0;
    }
}
