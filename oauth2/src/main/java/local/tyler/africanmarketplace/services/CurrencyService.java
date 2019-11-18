package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.models.Currency;

public interface CurrencyService {

    Currency getCurrencyByCode(String code);
}
