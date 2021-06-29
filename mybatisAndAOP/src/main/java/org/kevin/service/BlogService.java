package org.kevin.service;

import org.kevin.model.Blog;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
public interface BlogService {
    int insert(Blog blog);

    Blog selectById(Integer id);

    List<Blog> findAll();

    int deleteById(Integer id);
}
