package org.kevin.tacocloud.config;

import org.kevin.tacocloud.data.IngredientRepository;
import org.kevin.tacocloud.model.Ingredient;
import org.kevin.tacocloud.model.IngredientType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * @author Kevin.Zng
 * @date 2022/3/14 12:34
 */
@Configuration
@Profile("dev") // dev 环境下才启用 {"", "", ""} -- 需要多个环境同时起作用的情况下。
public class InitializeBeans {

    /**
     * 在忽略入参 args 的前提下，CommandLineRunner 和 ApplicationRunner 实现的事情是一样的。
     *
     * 差别在于，ApplicationRunner 获取的参数的方式为：<p>
     * <code> List<String> version = args.getOptionValue("version"); </code>
     * <p>需要再找资料吧，现在要知道的是 Spring 启动后会执行这两个 bean 的方法
     * @param repo
     * @return
     */
    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo) {
        return args -> {
            repo.save(new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP));
            repo.save(new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP));
            repo.save(new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN));
            repo.save(new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN));
            repo.save(new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES));
            repo.save(new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES));
            repo.save(new Ingredient("CHED", "Cheddar", IngredientType.CHEESE));
            repo.save(new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE));
            repo.save(new Ingredient("SLSA", "Salsa", IngredientType.SAUCE));
            repo.save(new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE));
        };
    }

//    @Bean
    /*public ApplicationRunner dataLoader2(IngredientRepository repo) {
        return args -> {
            repo.save(new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP));
            repo.save(new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP));
            repo.save(new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN));
            repo.save(new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN));
            repo.save(new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES));
            repo.save(new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES));
            repo.save(new Ingredient("CHED", "Cheddar", IngredientType.CHEESE));
            repo.save(new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE));
            repo.save(new Ingredient("SLSA", "Salsa", IngredientType.SAUCE));
            repo.save(new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE));
        };
    }*/
}
