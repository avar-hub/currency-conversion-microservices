package com.example.currencyconversionservice;

import com.example.currencyconversionservice.dto.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service" , url = "localhost:8000")
public interface CurrencyExchangeProxy {


    //Here we are hitting this url and we are getting response which is stored in currency-conversion
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion getCurrencyExchange(@PathVariable String from ,
                                                  @PathVariable String to);
}
