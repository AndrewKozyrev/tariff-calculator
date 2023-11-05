package ru.fastdelivery.domain.common.weight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class WeightTest {

    @Test
    void equalsTest() {
        var weight1 = new Weight(new BigDecimal("1000"));
        var weight2 = new Weight(new BigDecimal("1000.00"));

        assertThat(weight1)
                .isEqualTo(weight2)
                .hasSameHashCodeAs(weight2);
    }

    @Test
    @DisplayName("Добавление положительного веса -> вес увеличился")
    void whenAddPositiveWeight_thenWeightIsIncreased() {
        var weightBase = new Weight(new BigDecimal("1000"));
        var actual = weightBase.add(new Weight(new BigDecimal("1000")));

        assertThat(actual)
                .isEqualTo(new Weight(new BigDecimal("2000")));
    }

    @Test
    @DisplayName("Добавление отрицательного веса -> вес не изменился")
    void whenAddNegativeWeight_thenWeightIsNotChanged() {
        var weightBase = new Weight(new BigDecimal("1000"));
        var actual = weightBase.add(new Weight(new BigDecimal("-100")));

        assertThat(actual)
                .isEqualTo(new Weight(new BigDecimal("1000")));
    }
}