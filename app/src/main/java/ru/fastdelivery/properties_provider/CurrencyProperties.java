package ru.fastdelivery.properties_provider;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.fastdelivery.domain.common.currency.CurrencyPropertiesProvider;

import java.util.List;

@Configuration
@ConfigurationProperties("currency")
@Setter
public class CurrencyProperties implements CurrencyPropertiesProvider {

    private List<String> available;

    @Override
    public boolean isAvailable(String code) {
        return available.contains(code);
    }
}
