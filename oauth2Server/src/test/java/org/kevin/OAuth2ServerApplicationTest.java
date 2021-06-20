package org.kevin;

import org.junit.jupiter.api.Test;
import org.kevin.model.BlogUser;
import org.kevin.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OAuth2ServerApplicationTest {
    @Autowired
    private BlogUserService blogUserService;

    @Test
    public void selectUser(){
        String username = "kevin";
        BlogUser user = blogUserService.findBlogUserByUsername(username);
        System.out.println(user.getPassword());
    }
}