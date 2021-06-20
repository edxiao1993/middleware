package org.kevin.config.security;

import org.kevin.model.BlogUser;
import org.kevin.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin.Z
 * @version 2021/6/20
 */
@Configuration
@Primary
public class UserServiceAndPasswordEncoder implements UserDetailsService{
    @Autowired
    private BlogUserService blogUserService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        String defaultEncode = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(defaultEncode, new BCryptPasswordEncoder());
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        return new DelegatingPasswordEncoder(defaultEncode, encoders);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BlogUser blogUser = blogUserService.findBlogUserByUsername(username);
        if(blogUser == null){
            throw new UsernameNotFoundException("please check the username");
        }
        return new BlogUserServiceDetails(blogUser);
    }
}
