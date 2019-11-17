package local.tyler.africanmarketplace.repository;

import local.tyler.africanmarketplace.models.Category;
import local.tyler.africanmarketplace.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>
{

}
