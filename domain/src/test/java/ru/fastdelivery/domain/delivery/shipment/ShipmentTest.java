package ru.fastdelivery.domain.delivery.shipment;

import org.junit.jupiter.api.Test;
import ru.fastdelivery.domain.common.weight.WeightFactory;
import ru.fastdelivery.domain.delivery.pack.Pack;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShipmentTest {

    @Test
    void whenSummarizingWeightOfAllPackages_thenReturnSum() {
        var weightFactory = new WeightFactory();
        var weight1 = weightFactory.createFromGrams(BigDecimal.TEN);
        var weight2 = weightFactory.createFromGrams(BigDecimal.ONE);

        var packages = List.of(new Pack(weight1), new Pack(weight2));
        var shipment = new Shipment(packages);

        var massOfShipment = shipment.weightAllPackages();

        assertThat(massOfShipment.getWeightGrams()).isEqualByComparingTo(BigDecimal.valueOf(11));
    }
}