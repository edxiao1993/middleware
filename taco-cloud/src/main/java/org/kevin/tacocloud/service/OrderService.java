package org.kevin.tacocloud.service;

import org.kevin.tacocloud.data.OrderRepository;
import org.kevin.tacocloud.model.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author Kevin.Zng
 * @date 2022/3/30 00:47
 */
@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // SpEL 表达式
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrder() {
        orderRepository.deleteAll();
    }

    /**
     * 与 PreAuthorize 不同的地方在于，PostAuthorize 的作用是在
     *   执行完方法之后，在去判断 SpEL 表达式内的值是否为 true
     */
    @PostAuthorize("hasRole('ADMIN') || " +
        "returnObject.user.username == authentication.name")
    public TacoOrder getOrder(long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
