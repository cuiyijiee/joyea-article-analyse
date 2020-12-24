package me.cuiyijie.articleanalysis.controller;

import me.cuiyijie.articleanalysis.define.CommonResp;
import me.cuiyijie.articleanalysis.entity.Visitor;
import me.cuiyijie.articleanalysis.service.ReadRecordService;
import me.cuiyijie.articleanalysis.service.VisitorService;
import me.cuiyijie.articleanalysis.entity.vo.ReqUpdateVisitorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 17:33
 */

@Controller
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @Autowired
    ReadRecordService readRecordService;

    @RequestMapping("updateInfo")
    public String updateUserInfo(Model model,
                                 @RequestParam String webUrl,
                                 @RequestParam Long visitorId,
                                 @RequestParam Long webId) {
        model.addAttribute("webUrl", webUrl);
        model.addAttribute("visitorId", visitorId);
        model.addAttribute("webId", webId);
        return "updateInfo";
    }

    /**
     * private Long visitorId;
     * private String companyName;
     * private String position;
     * private String name;
     * private String mobileNumber;
     *
     * @param webUrl
     * @return
     */
    @RequestMapping("updateInfoAndGo")
    public String updateInfoAndGo(@RequestParam String webUrl,
                                  @RequestParam Long visitorId,
                                  @RequestParam Long webId,
                                  @RequestParam String companyName,
                                  @RequestParam String position,
                                  @RequestParam String name,
                                  @RequestParam String mobileNumber
    ) {
        readRecordService.addRecordById(webId, visitorId);
        visitorService.saveUserInfo(new ReqUpdateVisitorInfo(
                visitorId, companyName, position, name, mobileNumber
        ));
        return "redirect:" + webUrl;
    }

    @ResponseBody
    @PostMapping("api/visitor/updateInfo")
    public CommonResp updateInfo(@RequestBody ReqUpdateVisitorInfo reqUpdateVisitorInfo) {
        visitorService.saveUserInfo(reqUpdateVisitorInfo);
        return CommonResp.success(true);
    }

    @ResponseBody
    @RequestMapping("/api/visitor/infoComplete")
    public CommonResp<Boolean> queryUserInfoComplete(@RequestParam long visitorId) {
        Optional<Visitor> visitor = visitorService.findById(visitorId);
        return CommonResp.success(visitor.isPresent() && visitor.get().getCompanyName() != null);
    }
}
