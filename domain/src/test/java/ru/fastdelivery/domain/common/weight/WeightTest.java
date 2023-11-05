package ru.fastdelivery.domain.common.weight;

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
}