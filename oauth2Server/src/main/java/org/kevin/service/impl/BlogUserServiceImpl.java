package org.kevin.service.impl;

import org.kevin.mapper.BlogUserMapper;
import org.kevin.model.BlogUser;
import org.kevin.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kevin.Z
 * @version 2021/6/20
 */
@Service
public class BlogUserServiceImpl implements BlogUserService {
    @Autowired
    private BlogUserMapper blogUserMapper;

    @Override
    public BlogUser findBlogUserByUsername(String username) {
        return blogUserMapper.selectByUsername(username);
    }
}
