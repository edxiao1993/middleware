package org.kevin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private String company;
    private List<String> books;
}
