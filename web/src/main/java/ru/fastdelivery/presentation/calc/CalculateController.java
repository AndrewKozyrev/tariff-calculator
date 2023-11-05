package ru.fastdelivery.presentation.calc;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fastdelivery.presentation.api.request.CalculatePackagesRequest;
import ru.fastdelivery.domain.common.currency.CurrencyPropertiesProvider;

@RestController
@RequestMapping("/api/v1/calculate/")
@RequiredArgsConstructor
public class CalculateController {
    private final CurrencyPropertiesProvider currencyProperties;

    @PostMapping
    public CalculatePackagesRequest calculate(@Valid @RequestBody CalculatePackagesRequest request) {
        return request;
    }
}

