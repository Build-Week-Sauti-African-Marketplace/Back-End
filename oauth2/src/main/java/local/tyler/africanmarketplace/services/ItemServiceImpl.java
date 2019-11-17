package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.exceptions.ResourceNotFoundException;
import local.tyler.africanmarketplace.models.Category;
import local.tyler.africanmarketplace.models.Currency;
import local.tyler.africanmarketplace.models.Item;
import local.tyler.africanmarketplace.models.User;
import local.tyler.africanmarketplace.repository.ItemRepository;
import local.tyler.africanmarketplace.repository.UserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(value = "itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserService userService;

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
    public Item getItemByName(String itemName) {
        return itemRepository.findByName(itemName);
    }

    @Override
    public Item addItem(Item item) {
        User currentUser = userService.findUserById(item.getUser().getUserid());
        Item createItem = new Item();

        createItem.setLocation(item.getLocation());
        createItem.setName(item.getName());
        createItem.setDescription(item.getDescription());
        createItem.setPrice(item.getPrice());
        createItem.setUser(currentUser);

        for (Category c : item.getCategories()) {
            Category createCategory = new Category(c.getType(), createItem);
            createItem.getCategories().add(createCategory);
        }

        Currency c = item.getCurrency();
        Currency createCurrency = new Currency(c.getName(), c.getCode() , c.getSymbol(), createItem);
        createItem.setCurrency(createCurrency);

        return itemRepository.save(createItem);
    }


}
