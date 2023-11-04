package ru.fastdelivery.api.request;

import java.math.BigDecimal;

public record CargoPackage(
        BigDecimal weight
) {
}
