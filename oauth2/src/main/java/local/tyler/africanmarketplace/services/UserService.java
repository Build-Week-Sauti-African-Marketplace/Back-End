package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.models.User;
import local.tyler.africanmarketplace.view.UserNameCountEmails;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService
{
    List<User> findAll(Pageable pageable);

    List<User> findByNameContaining(String username,
                                    Pageable pageable);

    User findUserById(long id);

    User findByName(String name);

    void delete(long id);

    User save(User user);

    User update(User user,
                long id,
                boolean isAdmin);

    void deleteUserRole(long userid,
                        long roleid);

    void addUserRole(long userid,
                     long roleid);

    List<UserNameCountEmails> getCountUserEmails();

    User getCurrentUser();
}