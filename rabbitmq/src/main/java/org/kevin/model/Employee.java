package org.kevin.model;

import lombok.Data;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/16
 */
@Data
public class Employee {
    private String name;
    private String company;
    private List<String> books;
}
