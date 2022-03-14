package org.kevin.tacocloud.data;

import org.kevin.tacocloud.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kevin.Zng
 * @date 2022/3/14 12:17
 */
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
