package ru.fastdelivery.calc;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fastdelivery.api.request.CalculatePackagesRequest;

@RestController
@RequestMapping("/api/v1/calculate/")
public class CalculateController {

    @PostMapping
    public CalculatePackagesRequest calculate(@Valid @RequestBody CalculatePackagesRequest request) {
        System.out.println(request);
        return request;
    }
}

