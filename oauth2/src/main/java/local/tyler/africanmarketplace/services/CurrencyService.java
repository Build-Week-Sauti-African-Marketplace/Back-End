package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.models.Currency;

import java.util.List;

public interface CurrencyService {

    Currency getCurrencyByCode(String code);

    List<Currency> getAllCurrencies();

    Currency updateCurrencies(String code, Currency currency);
}
