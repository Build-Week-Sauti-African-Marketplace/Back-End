package local.tyler.africanmarketplace.controllers;

import local.tyler.africanmarketplace.models.Currency;
import local.tyler.africanmarketplace.models.Item;
import local.tyler.africanmarketplace.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(value = "/currencyupdate/{code}")
    public ResponseEntity<?> updateItem(@PathVariable String code, @RequestBody Currency currency) {
        currencyService.updateCurrencies(code, currency);
        return new ResponseEntity<>("Currency Updated", HttpStatus.OK);
    }

}
