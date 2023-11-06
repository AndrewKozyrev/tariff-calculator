package ru.fastdelivery.usecase;

import lombok.RequiredArgsConstructor;
import ru.fastdelivery.domain.delivery.shipment.Shipment;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class TariffCalculateUseCase {
    private final WeightPriceProvider weightPriceProvider;

    public CalculatedShipmentPrice calc(Shipment shipment) {
        var weightAllPackagesKg = shipment.weightAllPackages().kilograms();
        var minimalPrice = weightPriceProvider.minimalPrice();

        var totalPrice = weightPriceProvider.costPerKg().multiply(weightAllPackagesKg)
                .max(minimalPrice);

        return new CalculatedShipmentPrice(totalPrice, minimalPrice);
    }
}
