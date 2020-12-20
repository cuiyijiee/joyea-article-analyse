package me.cuiyijie.articleanalysis.controller;

import me.cuiyijie.articleanalysis.entity.ProductWeb;
import me.cuiyijie.articleanalysis.entity.Visitor;
import me.cuiyijie.articleanalysis.entity.wx.WxAccessToken;
import me.cuiyijie.articleanalysis.entity.wx.WxBaseUserInfo;
import me.cuiyijie.articleanalysis.service.ProductWebService;
import me.cuiyijie.articleanalysis.service.ReadRecordService;
import me.cuiyijie.articleanalysis.service.VisitorService;
import me.cuiyijie.articleanalysis.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 15:29
 */

@Controller
public class WeChatController {

    @Autowired
    WeChatService weChatService;
    @Autowired
    VisitorService visitorService;
    @Autowired
    ProductWebService productWebService;
    @Autowired
    ReadRecordService readRecordService;


    @RequestMapping("api/wechat/auth")
    public String auth(@RequestParam(name = "echostr") String echoStr, @RequestParam String signature, @RequestParam String timestamp, @RequestParam String nonce) {
        return echoStr;
    }

    @RequestMapping("api/wechat/redirect")
    public String redirectToRealUrl(@RequestParam String code, @RequestParam String state) throws UnsupportedEncodingException {

        WxAccessToken accessToken = weChatService.getAccessToken(code);
        WxBaseUserInfo wxBaseUserInfo = weChatService.getBaseUserInfo(accessToken.getAccessToken(), accessToken.getOpenId());
        if (wxBaseUserInfo == null) {
            return String.format("redirect:/customError?error=%s", URLEncoder.encode("微信用户信息获取失败!", "UTF-8"));
        }
        Visitor visitor = visitorService.saveOrUpdateUserWxInfo(wxBaseUserInfo);

        switch (state) {
            case "code":            //获取微信返回的code
                return String.format("redirect:/customError?error=%s", code);
            case "userInfo":        //获取用户信息
                return String.format("redirect:/customError?error=%s", visitor.toString());
            default:
                Long webId = Long.parseLong(state);
                Optional<ProductWeb> productWebOptional = productWebService.findById(webId);
                if (productWebOptional.isPresent()) {
                    if (visitor.getCompanyName() == null) {
                        return String.format("redirect:/updateInfo?webUrl=%s&visitorId=%s",
                                productWebOptional.get().webUrl, visitor.getId());
                    } else {
                        readRecordService.addReadRecord(productWebOptional.get(), visitor);
                        return String.format("redirect:%s", productWebOptional.get().webUrl);
                    }
                } else {
                    return String.format("redirect:/customError?error=%s", URLEncoder.encode("文章不可用!", "UTF-8"));
                }
        }
    }
}
