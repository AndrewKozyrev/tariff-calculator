package ru.fastdelivery.domain.common.weight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WeightTest {

    @Test
    @DisplayName("Попытка создать отрицательный вес -> исключение")
    void whenGramsBelowZero_thenException() {
        var weightGrams = new BigInteger("-1");
        assertThatThrownBy(() -> new Weight(weightGrams))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equalsTest() {
        var weight1 = new Weight(new BigInteger("1000"));
        var weight2 = new Weight(new BigInteger("1000"));

        assertThat(weight1)
                .isEqualTo(weight2)
                .hasSameHashCodeAs(weight2);
    }

    @Test
    @DisplayName("Добавление положительного веса -> вес увеличился")
    void whenAddPositiveWeight_thenWeightIsIncreased() {
        var weightBase = new Weight(new BigInteger("1000"));
        var actual = weightBase.add(new Weight(new BigInteger("1000")));

        assertThat(actual)
                .isEqualTo(new Weight(new BigInteger("2000")));
    }

    @Test
    @DisplayName("Первый вес больше второго -> true")
    void whenFirstWeightGreaterThanSecond_thenTrue() {
        var weightBig = new Weight(new BigInteger("1001"));
        var weightSmall = new Weight(new BigInteger("1000"));

        assertThat(weightBig.greaterThan(weightSmall)).isTrue();
    }

    @Test
    @DisplayName("Запрос количество кг -> получено корректное значение")
    void whenGetKilograms_thenReceiveKg() {
        var weight = new Weight(new BigInteger("1001"));

        var actual = weight.kilograms();

        assertThat(actual).isEqualByComparingTo(new BigDecimal("1.001"));
    }
}