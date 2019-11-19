package local.tyler.africanmarketplace;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import local.tyler.africanmarketplace.models.*;
import local.tyler.africanmarketplace.repository.CategoryRepository;
import local.tyler.africanmarketplace.repository.CurrencyRepository;
import local.tyler.africanmarketplace.repository.ItemRepository;
import local.tyler.africanmarketplace.services.CurrencyService;
import local.tyler.africanmarketplace.services.ItemService;
import local.tyler.africanmarketplace.services.RoleService;
import local.tyler.africanmarketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    CategoryRepository categoryRepository;




    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);

        // admin, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(),
                r1));
        admins.add(new UserRoles(new User(),
                r2));
        User u1 = new User("admin",
                "admin",
                admins);

        userService.save(u1);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u2 = new User("user",
                "user",
                users);

        userService.save(u2);

        Currency currency1 = new Currency("Algerian dinar", "DZD", "دج");
        Currency currency2 = new Currency("Angolan kwanza", "AOA", "Kz");
        Currency currency3 = new Currency("Botswana pula", "BWP", "P");
        Currency currency4 = new Currency("Burundi franc", "BIF", "");
        Currency currency5 = new Currency("CFA franc", "XOF", "");
        Currency currency6 = new Currency("CFA franc", "XAF", "");
        Currency currency7 = new Currency("Cape Verdean escudo", "CVE", "");
        Currency currency8 = new Currency("Comorian franc", "KMF", "");
        Currency currency9 = new Currency("Congolese franc", "CDF", "");
        Currency currency10 = new Currency("Djiboutian franc", "DJF", "");
        Currency currency11 = new Currency("Egyptian pound", "EGP", "");
        Currency currency12 = new Currency("Eritrean nakfa", "ERN", "");
        Currency currency13 = new Currency("Ethiopian birr", "ETB", "");
        Currency currency14 = new Currency("Dalasi", "GMD", "");
        Currency currency15 = new Currency("Ghanaian cedi", "GHS", "");
        Currency currency16 = new Currency("Guinean franc", "GNF", "");
        Currency currency17 = new Currency("Kenyan shilling", "KES", "");
        Currency currency18 = new Currency("Lesotho loti", "LSL", "");
        Currency currency19 = new Currency("Liberian dollar", "LRD", "$");
        Currency currency20 = new Currency("Libyan dinar", "LYD", "");
        Currency currency21 = new Currency("Malagasy ariary", "MGA", "");
        Currency currency22 = new Currency("Malawian kwacha", "MWK", "");
        Currency currency23 = new Currency("Ouguiya", "MRO", "");
        Currency currency24 = new Currency("Mauritian rupee", "MUR", "");
        Currency currency25 = new Currency("Moroccan dirham", "MAD", "");
        Currency currency26 = new Currency("Mozambican metical", "MZN", "");
        Currency currency27 = new Currency("Namibian dollar", "NAD", "");
        Currency currency28 = new Currency("Nigerian naira", "NGN", "");
        Currency currency29 = new Currency("Rwandan franc", "RWF", "");
        Currency currency30 = new Currency("São Tomé and Príncipe dobra", "STD", "");
        Currency currency31 = new Currency("Seychellois rupee", "SCR", "");
        Currency currency32 = new Currency("Sierra Leonean leone", "SLL", "");
        Currency currency33 = new Currency("Somali shilling", "SOS", "");
        Currency currency34 = new Currency("South African rand", "ZAR", "");
        Currency currency35 = new Currency("South Sudanese pound", "SSP", "");
        Currency currency36 = new Currency("Sudanese pound", "SDG", "");
        Currency currency37 = new Currency("Swazi lilangeni", "SZL", "");
        Currency currency38 = new Currency("Tanzanian shilling", "TZS", "");
        Currency currency39 = new Currency("Tunisian dinar", "TND", "");
        Currency currency40 = new Currency("Ugandan shilling", "UGX", "");
        Currency currency41 = new Currency("Zambian kwacha", "ZMW", "");
        Currency currency42 = new Currency("RTGS Dollar", "ZBN", "");

        currencyRepository.save(currency1);
        currencyRepository.save(currency2);
        currencyRepository.save(currency3);
        currencyRepository.save(currency4);
        currencyRepository.save(currency5);
        currencyRepository.save(currency6);
        currencyRepository.save(currency7);
        currencyRepository.save(currency8);
        currencyRepository.save(currency9);
        currencyRepository.save(currency10);
        currencyRepository.save(currency11);
        currencyRepository.save(currency12);
        currencyRepository.save(currency13);
        currencyRepository.save(currency14);
        currencyRepository.save(currency15);
        currencyRepository.save(currency16);
        currencyRepository.save(currency17);
        currencyRepository.save(currency18);
        currencyRepository.save(currency19);
        currencyRepository.save(currency20);
        currencyRepository.save(currency21);
        currencyRepository.save(currency22);
        currencyRepository.save(currency23);
        currencyRepository.save(currency24);
        currencyRepository.save(currency25);
        currencyRepository.save(currency26);
        currencyRepository.save(currency27);
        currencyRepository.save(currency28);
        currencyRepository.save(currency29);
        currencyRepository.save(currency30);
        currencyRepository.save(currency31);
        currencyRepository.save(currency32);
        currencyRepository.save(currency33);
        currencyRepository.save(currency34);
        currencyRepository.save(currency35);
        currencyRepository.save(currency36);
        currencyRepository.save(currency37);
        currencyRepository.save(currency38);
        currencyRepository.save(currency39);
        currencyRepository.save(currency40);
        currencyRepository.save(currency41);
        currencyRepository.save(currency42);

        Category category1 = new Category("Electronics");
        Category category2 = new Category("Clothing & Accessories");
        Category category3 = new Category("Hobbies");
        Category category4 = new Category("Home & Garden");
        Category category5 = new Category("Entertainment");
        Category category6 = new Category("Family");
        Category category7 = new Category("Grocery");
        Category category8 = new Category("Other");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);
        categoryRepository.save(category5);
        categoryRepository.save(category6);
        categoryRepository.save(category7);
        categoryRepository.save(category8);


    }
}