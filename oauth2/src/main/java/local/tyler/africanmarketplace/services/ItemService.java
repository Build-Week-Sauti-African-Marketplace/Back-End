package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.models.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    Item getItemById(long id);

    List<Item> getItemsByName(String name);

    Item addItem(Item item);

    List<Item> getItemsByNameContaining(String name);

    void deleteItem(long id);

    Item updateItem(long id, Item item);

}
