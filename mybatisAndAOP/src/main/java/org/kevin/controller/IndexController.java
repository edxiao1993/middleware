package org.kevin.controller;

import org.kevin.annotation.MyLogger;
import org.kevin.model.Blog;
import org.kevin.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
@RestController
public class IndexController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/insert")
    public String insert(@RequestParam("name") String name, @RequestParam("pwd") String pwd){
        System.out.println("                controller");
        blogService.insert(new Blog());
        return "insert done";
    }

    @GetMapping("/delete")
    @MyLogger(value = "this is value from myLogger")
    public String delete(){
        System.out.println("                controller");
        return "delete done";
    }
}
