package me.cuiyijie.articleanalysis.controller;

import me.cuiyijie.articleanalysis.define.CommonResp;
import me.cuiyijie.articleanalysis.service.VisitorService;
import me.cuiyijie.articleanalysis.vo.ReqUpdateVisitorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 17:33
 */

@Controller
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @RequestMapping("updateInfo")
    public String updateUserInfo() {
        return "updateInfo";
    }


    @PostMapping("api/visitor/updateInfo")
    public CommonResp updateInfo(@RequestBody ReqUpdateVisitorInfo reqUpdateVisitorInfo) {

        visitorService.saveUserInfo(reqUpdateVisitorInfo);

        return CommonResp.success(true);
    }
}
