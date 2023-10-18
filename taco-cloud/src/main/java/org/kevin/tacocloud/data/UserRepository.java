package org.kevin.tacocloud.data;

import org.kevin.tacocloud.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Kevin.Zng
 * @date 2022/3/21 23:59
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
