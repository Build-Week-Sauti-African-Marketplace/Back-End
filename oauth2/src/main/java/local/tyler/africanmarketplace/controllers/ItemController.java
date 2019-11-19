package local.tyler.africanmarketplace.controllers;

import local.tyler.africanmarketplace.models.Item;
import local.tyler.africanmarketplace.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/items")
    public ResponseEntity<?> listAllItems() {
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(value = "/item/{id}")
    public ResponseEntity<?> getItemById(@PathVariable long id) {
        Item item = itemService.getItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping(value = "/itemname/{name}")
    public ResponseEntity<?> getItemsByName(@PathVariable String name) {
        List<Item> items = itemService.getItemsByName(name);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(value = "/itemname/contains/{name}")
    public ResponseEntity<?> getItemsByLikeName(@PathVariable String name) {
        List<Item> items = itemService.getItemsByNameContaining(name);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping(value = "/item")
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        item = itemService.addItem(item);
        return new ResponseEntity<>("Item's id: " + item.getItemid(), HttpStatus.CREATED);
    }

}
