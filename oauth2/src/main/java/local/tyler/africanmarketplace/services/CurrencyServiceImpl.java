package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.models.Currency;
import local.tyler.africanmarketplace.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "currencyService")
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public Currency getCurrencyByCode(String code) {
        return currencyRepository.findByCodeIgnoreCase(code);
    }
}
