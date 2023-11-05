package ru.fastdelivery.domain.common.weight;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Getter
public class Weight {
    private final BigDecimal weightGrams;

    public static Weight zero(){
        return new Weight(BigDecimal.ZERO);
    }

    Weight(BigDecimal weightGrams) {
        var normalizeWeight = weightGrams.compareTo(BigDecimal.ZERO) > 0
           && weightGrams.compareTo(BigDecimal.ONE) < 0 ? BigDecimal.ONE : weightGrams;

        this.weightGrams = normalizeWeight.setScale(0, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Weight weight = (Weight) o;
        return weightGrams.compareTo(weight.weightGrams) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weightGrams);
    }

    public Weight add(Weight additionalWeight) {
        if(additionalWeight.weightGrams.compareTo(BigDecimal.ZERO) < 0) {
            return new Weight(this.weightGrams);
        }

        return new Weight(this.weightGrams.add(additionalWeight.weightGrams));
    }
}
