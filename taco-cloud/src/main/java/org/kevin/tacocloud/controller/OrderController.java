package org.kevin.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.kevin.tacocloud.model.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * @author Kevin.Zng
 * @date 2022/3/9 01:01
 */
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, SessionStatus sessionStatus) {
        log.info("Order submitted: {}", tacoOrder);
        // the session is cleaned up and ready for a new order the next time the user creates a taco ???
        // 存储在 Session 里的对象到这里就结束了？怎么知道结束的对象是 tacoOrder 呢？
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
