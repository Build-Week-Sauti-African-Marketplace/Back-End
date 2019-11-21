package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.models.Currency;
import local.tyler.africanmarketplace.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    @Override
    public Currency updateCurrencies(String code, Currency currency) {
        Currency currentCurrency = currencyRepository.findByCodeIgnoreCase(code);
        if (currency.getCode() != null) {
            currentCurrency.setCode(currency.getCode());
        }
        if (currency.getName() != null) {
            currentCurrency.setName(currency.getName());
        }
        if (currency.getSymbol() != null) {
            currentCurrency.setSymbol(currency.getSymbol());
        }
        if (currency.hasValue) {
            currentCurrency.setValueInUSD(currency.getValueInUSD());
        }
        return currencyRepository.save(currentCurrency);

    }
}
