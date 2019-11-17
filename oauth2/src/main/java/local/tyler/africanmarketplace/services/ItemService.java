package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.models.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    Item getItemById(long id);

    Item getItemByName(String itemName);

    Item addItem(Item item);

}
