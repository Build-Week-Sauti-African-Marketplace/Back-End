package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.exceptions.ResourceNotFoundException;
import local.tyler.africanmarketplace.exceptions.ValidationError;
import local.tyler.africanmarketplace.models.Category;
import local.tyler.africanmarketplace.models.Currency;
import local.tyler.africanmarketplace.models.Item;
import local.tyler.africanmarketplace.models.User;
import local.tyler.africanmarketplace.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Transactional
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

    @Transactional
    @Override
    public Item addItem(Item item) {

        User currentUser = userService.getCurrentUser();
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

    @Transactional
    @Override
    public Item updateItem(long id, Item item) {
        Item currentItem = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        String username = currentItem.getUser().getUsername();
        if (username.equals(userService.getCurrentUser().getUsername())){
            if (item.getLocation() != null) {
                currentItem.setLocation(item.getLocation());
            }
            if (item.getName() != null) {
                currentItem.setName(item.getName());
            }
            if (item.getDescription() != null) {
                currentItem.setDescription(item.getDescription());
            }
            if (item.hasPrice) {
                currentItem.setPrice(item.getPrice());
            }
            if (item.getCurrency() != null) {
                currentItem.setCurrency(item.getCurrency());
            }
            if (item.getCategory() != null) {
                currentItem.setCategory(item.getCategory());
            }
        } else {
            throw new ValidationException("Not your item to update");
        }

        return itemRepository.save(currentItem);

    }

    @Override
    public void deleteItem(long id) {
        Item currentItem = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        String username = currentItem.getUser().getUsername();

        if (username.equals(userService.getCurrentUser().getUsername())){
            itemRepository.delete(currentItem);
        } else {
            throw new ValidationException("Not your item to delete");
        }


    }




}
