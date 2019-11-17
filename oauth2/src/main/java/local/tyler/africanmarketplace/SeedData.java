package local.tyler.africanmarketplace;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import local.tyler.africanmarketplace.models.*;
import local.tyler.africanmarketplace.repository.ItemRepository;
import local.tyler.africanmarketplace.services.ItemService;
import local.tyler.africanmarketplace.services.RoleService;
import local.tyler.africanmarketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;


    @Override
    public void run(String[] args) throws Exception
    {
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

        User test = userService.findUserById(12);

        Item item = new Item("there", "not milk", "not a gallon of milk", 7.00, test);

        List<Category> categories = new ArrayList<>();
        Category category = new Category("Not produce", item);
        categories.add(category);
        item.setCategories(categories);

        Currency currency = new Currency("Pounds", "EGP", "£", item);
        item.setCurrency(currency);

        itemService.addItem(item);








        // using JavaFaker create a bunch of regular users
        // https://www.baeldung.com/java-faker
        // https://www.baeldung.com/regular-expressions-java

        /*FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"),
                                                                    new RandomService());
        Faker nameFaker = new Faker(new Locale("en-US"));

        for (int i = 0; i < 100; i++)
        {
            new User();
            User fakeUser;

            users = new ArrayList<>();
            users.add(new UserRoles(new User(),
                                    r2));
            fakeUser = new User(nameFaker.name()
                                         .username(),
                                "password",
                                users);
            userService.save(fakeUser);
        }*/
    }
}