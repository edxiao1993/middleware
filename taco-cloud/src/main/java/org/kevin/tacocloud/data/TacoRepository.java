package org.kevin.tacocloud.data;

import org.kevin.tacocloud.model.Taco;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Kevin.Zng
 * @date 2022/4/2 00:20
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
