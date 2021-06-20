package org.kevin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kevin.Z
 * @version 2021/6/20
 */
@RestController
public class Controller {

    @GetMapping("/index")
    public String index(){
        return "hello oauth2serverService";
    }
}
