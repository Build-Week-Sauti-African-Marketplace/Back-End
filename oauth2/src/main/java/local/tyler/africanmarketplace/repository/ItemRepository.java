package local.tyler.africanmarketplace.repository;

import local.tyler.africanmarketplace.models.Item;
import local.tyler.africanmarketplace.models.Role;
import local.tyler.africanmarketplace.view.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAllByNameIgnoreCase(String name);

    List<Item> findAllByNameContainingIgnoreCase(String name);

}
