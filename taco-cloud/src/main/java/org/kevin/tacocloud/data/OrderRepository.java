package org.kevin.tacocloud.data;

import org.kevin.tacocloud.model.TacoOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kevin.Zng
 * @date 2022/3/14 12:19
 */
@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    /*@Query("SELECT o.id, o.placed_at, o.delivery_name, o.delivery_city, o.delivery_state, o.delivery_zip, o.cc_number, " +
            "o.cc_expiration, o.cc_cvv FROM taco_order o where o.delivery_city='Seattle'")*/
    @Query(value = "SELECT * from tack_order WHERE delivery_city='Seattle'", nativeQuery = true)
    List<TacoOrder> readOrdersDeliveredInSeattle();
}
