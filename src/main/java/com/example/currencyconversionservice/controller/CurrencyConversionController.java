package com.example.currencyconversionservice.controller;

import com.example.currencyconversionservice.CurrencyExchangeProxy;
import com.example.currencyconversionservice.dto.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;


@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    //We are using rest template in this method

//    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//    public CurrencyConversion calculateCurrencyConversion (@PathVariable String from,
//                                                           @PathVariable String to,
//                                                           @PathVariable BigDecimal quantity) {
//
//        HashMap<String,String> uriVariables= new HashMap<>();
//        uriVariables.put("from",from);
//        uriVariables.put("to",to);
//
//        ResponseEntity<CurrencyConversion> conversionResponse= new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);
//        CurrencyConversion currencyConversion= conversionResponse.getBody();
//        return new CurrencyConversion(currencyConversion.getId()
//                ,currencyConversion.getFrom()
//                ,currencyConversion.getTo(),quantity.multiply(quantity),BigDecimal.ONE,BigDecimal.ONE,"");
//    }

    //We are using fiegn client in this method
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion (@PathVariable String from,
                                                           @PathVariable String to,
                                                           @PathVariable BigDecimal quantity) {


       CurrencyConversion currencyConversion= proxy.getCurrencyExchange(from,to);
        return new CurrencyConversion(currencyConversion.getId()
                ,currencyConversion.getFrom()
                ,currencyConversion.getTo(),quantity.multiply(quantity),BigDecimal.ONE,BigDecimal.ONE,"");
    }

}
