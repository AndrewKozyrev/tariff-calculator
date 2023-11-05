package ru.fastdelivery.domain.common.price;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.fastdelivery.domain.common.currency.Currency;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PriceFactoryTest {

    Currency currency = mock(Currency.class);

    @ParameterizedTest(name = "Стоимость = {arguments} -> объект создан")
    @ValueSource(doubles = { 0, 0.01, 100, 10_000 })
    void whenAmountGreaterThanZero_thenObjectCreated(double amount) {
        var price = new PriceFactory().create(BigDecimal.valueOf(amount), currency);

        assertNotNull(price);
        assertThat(price.getAmount()).isEqualByComparingTo(BigDecimal.valueOf(amount));
        assertThat(price.getCurrency()).isEqualTo(currency);
    }

    @ParameterizedTest(name = "Стоимость = {arguments} -> исключение")
    @ValueSource(doubles = { -0.01, -0.00000001, -100, -10_000 })
    @DisplayName("Значение стоимости ниже 0.00 -> исключение")
    void whenAmountLessThanZero_thenThrowException(double amount) {
        assertThatThrownBy(() -> new PriceFactory().create(BigDecimal.valueOf(amount), currency))
                .isInstanceOf(IllegalArgumentException.class);
    }
}