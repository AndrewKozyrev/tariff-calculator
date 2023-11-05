package ru.fastdelivery.presentation.api.request;

import java.math.BigDecimal;

public record CargoPackage(
        BigDecimal weight
) {
}
