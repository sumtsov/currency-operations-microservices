package com.dsumtsov.microservices.currencyexchangeservice.controller;

import com.dsumtsov.microservices.currencyexchangeservice.dto.CurrencyExchangeDTO;
import com.dsumtsov.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "currency-exchange")
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeService service;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchangeDTO retrieveExchangeValue(@PathVariable String from,
                                                     @PathVariable String to) {

        log.info("Exchange request params: from={}, to={}", from, to);

        return service.retrieveExchangeValue(from, to);
    }
}
