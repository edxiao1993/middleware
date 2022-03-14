package org.kevin.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.kevin.tacocloud.data.IngredientRepository;
import org.kevin.tacocloud.model.Ingredient;
import org.kevin.tacocloud.model.IngredientType;
import org.kevin.tacocloud.model.Taco;
import org.kevin.tacocloud.model.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Kevin.Zng
 * @date 2022/3/9 00:32
 */
@Slf4j
@Controller
@RequestMapping("/design")
// tacoOrder, line 51: should be maintained in session.
// not so clear
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private IngredientRepository ingredientRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    /**
     * 当处理一个 request 时，这个方法也会被调用
     *
     * @param model
     */
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredientList = ingredientRepository.findAll();

        IngredientType[] types = IngredientType.values();

        for (IngredientType type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByTye(ingredientList, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByTye(Iterable<Ingredient> ingredientList, IngredientType type) {
        Collection<Ingredient> result = new ArrayList<>();
        ingredientList.forEach(x -> {
            if (x.getType().equals(type)) {
                result.add(x);
            }
        });
        return result;
    }
}
