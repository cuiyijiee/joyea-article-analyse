package me.cuiyijie.articleanalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/17 22:10
 */
@Controller
public class UserController {

    @RequestMapping("/")
    public String index(){
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
