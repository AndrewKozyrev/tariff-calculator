package ru.fastdelivery.domain.common.weight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WeightFactoryTest {

    @ParameterizedTest(name = "Граммы = {arguments} -> объект создан")
    @ValueSource(doubles = { 0, 1, 100, 10_000 })
    void whenGramsGreaterThanZero_thenObjectCreated(double amount) {
        var weight = new WeightFactory().createFromGrams(BigDecimal.valueOf(amount));

        assertNotNull(weight);
        assertThat(weight.getWeightGrams()).isEqualByComparingTo(BigDecimal.valueOf(amount));
    }

    @ParameterizedTest(name = "Стоимость = {arguments} -> исключение")
    @ValueSource(doubles = { -0.01, -0.00000001, -100, -10_000 })
    @DisplayName("Значение стоимости ниже 0.00 -> исключение")
    void whenGramsLessThanZero_thenThrowException(double amount) {
        assertThatThrownBy(() -> new WeightFactory().createFromGrams(BigDecimal.valueOf(amount)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Значение стоимости null -> исключение")
    void whenGramsIsNull_thenThrowException() {
        assertThatThrownBy(() -> new WeightFactory().createFromGrams(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}