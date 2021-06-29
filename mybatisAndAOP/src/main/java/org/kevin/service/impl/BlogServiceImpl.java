package org.kevin.service.impl;

import org.kevin.model.Blog;
import org.kevin.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Override
    public int insert(Blog blog) {
        System.out.println("--------------insert");
        return 0;
    }

    @Override
    public Blog selectById(Integer id) {
        System.out.println("++++++++++++++++++selectById");
        return null;
    }

    @Override
    public List<Blog> findAll() {
        System.out.println("===================findAll");
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        System.out.println("**********************deleteById");
        return 0;
    }
}
