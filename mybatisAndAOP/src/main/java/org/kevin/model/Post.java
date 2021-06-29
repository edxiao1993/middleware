package org.kevin.model;

import lombok.Data;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
@Data
public class Post {
    private int id;
    private String title;
    private String content;
    private List<Tags> tags;
}
