package org.kevin.tacocloud.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Kevin.Zng
 * @date 2022/3/9 00:23
 */
@Entity
@Data
@AllArgsConstructor
// 构造器的修饰符是 private，force=true 即让元素的值为默认值。比如 boolean=false，String=null，……
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Proxy(lazy = false)
public class Ingredient {

    @Id
    private String id;
    private String name;
    private IngredientType type;
}
