package org.kevin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Kevin.Z
 * @version 2021/6/27
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests(authorize -> authorize.anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults());
    }
}
