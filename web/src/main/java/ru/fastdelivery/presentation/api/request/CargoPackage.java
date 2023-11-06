package ru.fastdelivery.presentation.api.request;

import java.math.BigInteger;

public record CargoPackage(
        BigInteger weight
) {
}
