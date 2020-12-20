package me.cuiyijie.articleanalysis.controller;

import me.cuiyijie.articleanalysis.define.CommonResp;
import me.cuiyijie.articleanalysis.service.VisitorService;
import me.cuiyijie.articleanalysis.entity.vo.ReqUpdateVisitorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 17:33
 */

@Controller
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @RequestMapping("updateInfo")
    public String updateUserInfo(Model model, @RequestParam String webUrl, @RequestParam Long visitorId) {
        model.addAttribute("webUrl", webUrl);
        model.addAttribute("visitorId", visitorId);
        return "updateInfo";
    }


    @ResponseBody
    @PostMapping("api/visitor/updateInfo")
    public CommonResp updateInfo(@RequestBody ReqUpdateVisitorInfo reqUpdateVisitorInfo) {
        visitorService.saveUserInfo(reqUpdateVisitorInfo);
        return CommonResp.success(true);
    }
}
