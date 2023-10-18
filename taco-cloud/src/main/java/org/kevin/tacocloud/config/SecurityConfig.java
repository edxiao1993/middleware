package org.kevin.tacocloud.config;

import org.kevin.tacocloud.data.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

/**
 * EnableGlobalMethodSecurity 的作用是使 PreAuthorize 全局生效
 *
 * @author Kevin.Zng
 * @date 2022/3/21 23:46
 */
@Configuration
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
//        List<UserDetails> userList = new ArrayList<>();
//        userList.add(new User("buzz", encoder.encode("password"),
//                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))));
//        userList.add(new User("woody", encoder.encode("password"),
//                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))));
//        return new InMemoryUserDetailsManager(userList);


        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                org.kevin.tacocloud.model.User user = userRepo.findByUsername(username);
                if (Objects.nonNull(user)) {
                    return user;
                }

                throw new UsernameNotFoundException("User '" + username + "' not found");
            }
        };
        // 上面或许能看得清楚些。下面的 lambda 代码就是上面的简写版…… 第一次看确实觉得很奇怪。
        // 不过，lambda 不就是这么搞的吗？一个接口里只有一个方法……
//        return username -> {
//            org.kevin.tacocloud.model.User user = userRepo.findByUsername(username);
//            if (Objects.nonNull(user)) {
//                return user;
//            }
//
//            throw new UsernameNotFoundException("User '" + username + "' not found");
//        };
    }
}
