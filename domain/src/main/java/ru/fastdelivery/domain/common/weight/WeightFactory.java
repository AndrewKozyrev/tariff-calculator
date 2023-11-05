package ru.fastdelivery.domain.common.weight;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class WeightFactory {

    public Weight createFromGrams(BigDecimal weightGrams) {
        if(weightGrams == null){
            throw new IllegalArgumentException("Weight cannot be null!");
        }

        if (isLessThanZero(weightGrams)) {
            throw new IllegalArgumentException("Weight cannot be below Zero!");
        }
        
        return new Weight(weightGrams);
    }

    private static boolean isLessThanZero(BigDecimal price) {
        return BigDecimal.ZERO.compareTo(price) > 0;
    }
}
