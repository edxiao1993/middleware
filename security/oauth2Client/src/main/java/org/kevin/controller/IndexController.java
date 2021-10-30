package org.kevin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;
/**
 * @author Kevin.Z
 * @version 2021/6/27
 */
@RestController
public class IndexController {
    @Autowired
    private WebClient webClient;
    private String hUri = "http://8080/hello";

    @PostMapping(value = "/authorize")
    public String passwordGrant(Model model){
        String msg = retrieveMessages("password");
        model.addAttribute("msg", msg);
        return "index";
    }

    private String retrieveMessages(String clientRegistrationId){
        return webClient
                .get()
                .uri(hUri)
                .attributes(clientRegistrationId(clientRegistrationId))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @GetMapping("/index")
    public String string(){
        System.out.println("this is index~");
        return "index";
    }
}
