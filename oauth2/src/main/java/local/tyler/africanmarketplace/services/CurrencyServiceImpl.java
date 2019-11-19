package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.models.Currency;
import local.tyler.africanmarketplace.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "currencyService")
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public Currency getCurrencyByCode(String code) {
        return currencyRepository.findByCodeIgnoreCase(code);
    }

    @Override
    public List<Currency> getAllCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        currencyRepository.findAll().iterator().forEachRemaining(currencies::add);
        return currencies;
    }
}
