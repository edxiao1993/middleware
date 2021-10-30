package org.kevin.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Kevin.Z
 * @version 2021/6/20
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Override
    public void configure(AuthenticationManagerBuilder managerBuilder){
        managerBuilder.authenticationProvider(authenticationProvider);
    }
}
