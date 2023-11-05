package ru.fastdelivery.domain.common.price;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.fastdelivery.domain.common.currency.Currency;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Price {
    private final BigDecimal amount;
    private final Currency currency;
}
