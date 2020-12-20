package me.cuiyijie.articleanalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 17:45
 */
@Controller
public class ErrorController {

    @RequestMapping("/customError")
    public String errorPage(Model model, @RequestParam String error) {
        model.addAttribute("error", error);
        return "error";
    }
}
