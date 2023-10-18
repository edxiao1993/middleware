package org.kevin.tacocloud.controller.rest;

import org.kevin.tacocloud.data.OrderRepository;
import org.kevin.tacocloud.data.TacoRepository;
import org.kevin.tacocloud.model.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Kevin.Zng
 * @date 2022/4/2 00:11
 */
@RestController
@RequestMapping(path = "/api/tacos",
        // only the request with an Accept header that includes "application/json" -- 现在才知道。。。Damn it
        produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoController {

    private TacoRepository tacoRepository;
    private OrderRepository orderRepository;

    @Autowired
    public TacoController(TacoRepository tacoRepository, OrderRepository orderRepository) {
        this.tacoRepository = tacoRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping(params = "recent")
    public Iterable<Taco> recentTaco() {
        //
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
//        return tacoRepository.findAll(page).getContent();
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Taco> tacoById(@PathVariable("id") Long id) {
        return tacoRepository.findById(id);
    }

    @GetMapping("/another/{id}")
    public ResponseEntity<Taco> getAnotherById(@PathVariable("id") Long id) {
        Optional<Taco> optionalTaco = tacoRepository.findById(id);
        if (optionalTaco.isPresent()) {
            return new ResponseEntity<>(optionalTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // consumes: request input. Content-Type: application/json. 注意与 produces 区别
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {}
    }
}
