package org.kevin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;

/**
 * @author Kevin.Z
 * @version 2021/6/28
 */
@Configuration
public class CustomOAuth2LoginConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        return new InMemoryClientRegistrationRepository(this.myAuthServer());
    }

    private ClientRegistration myAuthServer(){
        return ClientRegistration.withRegistrationId("myauthserver")
                .clientId("client1")
                .clientSecret("secret1")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("http://localhost:8331/index")
                .scope("webapp", "mobile")
                .authorizationUri("http://localhost:8333/oauth/authorize")
                .tokenUri("http://localhost:8333/oauth/token")
                .build();
    }


}
