package org.kevin.tacocloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Kevin.Zng
 * @date 2022/3/30 00:22
 */
@Configuration
public class SecurityFilter {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests() // 返回一个 ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry
                // 从而配置 url 的 安全要求，比如 role 之类的
                  // 好像越加越复杂了……这里的意思是调用 /admin/** 的请求必须要有 ADMIN 的角色
                  //  当然，在调用的方法那里加也是可以的
//                .antMatchers(HttpMethod.POST, "/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/design", "orders").hasRole("USER")
                .antMatchers("/", "/**").permitAll()
                .and()
                // 登陆页面
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .usernameParameter("user")
                .passwordParameter("pwd")
                // 登陆成功之后强制跳转到 /design 页面
                .defaultSuccessUrl("/design", true)
                .and()
                // 登出
//                .logout()
//                .logoutSuccessUrl("/")
//                .and()
                // 禁用 csrf，不建议……
//                .csrf().disable()
                .build();
        // 有个 access 的方法，这里记录下。。。
    }


}
