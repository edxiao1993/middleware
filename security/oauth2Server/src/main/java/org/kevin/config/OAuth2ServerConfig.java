package org.kevin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;

import java.util.List;
import java.util.Map;

/**
 * @author Kevin.Z
 * @version 2021/6/27
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endPoints) throws Exception{
        endPoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        /*InMemoryClientDetailsService service = new InMemoryClientDetailsService();
        BaseClientDetails bcd = new BaseClientDetails();
        bcd.setClientId("client");
        bcd.setClientSecret("secret");
        bcd.setScope(List.of("webapp", "mobile"));
        bcd.setAuthorizedGrantTypes(List.of("password", "refresh_token"));
        service.setClientDetailsStore(Map.of("client", bcd));
        clients.withClientDetails(service);*/

        // for reference to quick start
        /* clients.inMemory()
                .withClient("client")
                .secret("secret")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("webapp", "mobile");*/

        clients.inMemory()
                .withClient("client1")
                .secret("secret1")
                .authorizedGrantTypes("authorization_code")
                .scopes("webapp", "mobile")
                .redirectUris("http://localhost:8331/index")

                .and()

                // this client2 can use any of authorization_code, password, refresh_token
                .withClient("client2")
                .secret("secret2")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("webapp", "mobile")
                .redirectUris("http://localhost:8331/index");
    }
}
