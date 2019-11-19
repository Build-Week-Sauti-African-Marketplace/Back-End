package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.exceptions.ResourceNotFoundException;
import local.tyler.africanmarketplace.models.Category;
import local.tyler.africanmarketplace.models.Currency;
import local.tyler.africanmarketplace.models.Item;
import local.tyler.africanmarketplace.models.User;
import local.tyler.africanmarketplace.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service(value = "itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserService userService;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    CategoryService categoryService;

    @Override
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        itemRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Item getItemById(long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public List<Item> getItemsByName(String name) {
        return itemRepository.findAllByNameIgnoreCase(name);
    }

    @Override
    public List<Item> getItemsByNameContaining(String name) {
        return itemRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public Item addItem(Item item) {

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        User currentUser = userService.findByName(username);
        Item createItem = new Item();

        createItem.setLocation(item.getLocation());
        createItem.setName(item.getName());
        createItem.setDescription(item.getDescription());
        createItem.setPrice(item.getPrice());
        createItem.setUser(currentUser);

        Category category = categoryService.getCategoryByType(item.getCategory().getType());
        createItem.setCategory(category);

        Currency currency = currencyService.getCurrencyByCode(item.getCurrency().getCode());
        createItem.setCurrency(currency);


        return itemRepository.save(createItem);
    }




}
