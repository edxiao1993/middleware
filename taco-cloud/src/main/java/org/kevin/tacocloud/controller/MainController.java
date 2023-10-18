package org.kevin.tacocloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kevin.Zng
 * @date 2022/3/7 01:43
 */
@RestController
public class MainController {

    @GetMapping("/index")
    public String index() {
        return "hello world~";
    }


}
