package org.kevin.model;

import lombok.Data;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
@Data
public class Blog {
    private int id;
    private Author author;
    private List<Post> posts;
}
