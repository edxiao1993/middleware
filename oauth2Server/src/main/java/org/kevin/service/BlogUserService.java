package org.kevin.service;

import org.kevin.model.BlogUser;

/**
 * @author Kevin.Z
 * @version 2021/6/20
 */
public interface BlogUserService {

    BlogUser findBlogUserByUsername(String username);
}
