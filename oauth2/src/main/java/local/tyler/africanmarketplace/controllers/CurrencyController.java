package local.tyler.africanmarketplace.controllers;

import local.tyler.africanmarketplace.models.Currency;
import local.tyler.africanmarketplace.models.Item;
import local.tyler.africanmarketplace.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping(value = "/currencies")
    public ResponseEntity<?> listAllCurrencies() {
        List<Currency> currencies = currencyService.getAllCurrencies();
        return new ResponseEntity<>(currencies, HttpStatus.OK);
    }

}
