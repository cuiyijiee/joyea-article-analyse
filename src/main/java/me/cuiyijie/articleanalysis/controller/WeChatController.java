package me.cuiyijie.articleanalysis.controller;

import me.cuiyijie.articleanalysis.define.Constants;
import me.cuiyijie.articleanalysis.entity.ProductWeb;
import me.cuiyijie.articleanalysis.entity.Visitor;
import me.cuiyijie.articleanalysis.entity.wx.WxAccessToken;
import me.cuiyijie.articleanalysis.entity.wx.WxBaseUserInfo;
import me.cuiyijie.articleanalysis.service.ProductWebService;
import me.cuiyijie.articleanalysis.service.VisitorService;
import me.cuiyijie.articleanalysis.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

/**
 * @author cyj976655@gmail.com
 * @date 2021/2/21 13:37
 */
@Controller
public class WeChatController {

    @Autowired
    ProductWebService productWebService;
    @Autowired
    WeChatService weChatService;
    @Autowired
    VisitorService visitorService;

    @RequestMapping("preview")
    public String preview(@RequestParam(value = "webId") Optional<Long> webIdOpt,
                          Model model,
                          @RequestParam Optional<String> code,
                          @RequestParam Optional<String> state
    ) throws UnsupportedEncodingException {
        if (!code.isPresent()) {

            Optional<ProductWeb> productWebOptional = productWebService.findById(webIdOpt.orElse(-1L));
            if (productWebOptional.isPresent()) {
                //构建微信授权信息，并跳转到当前网址，以便微信进行分享
                return String.format(
                        "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=https://scan.joyea.cn/preview?webId=%s&response_type=code&scope=snsapi_userinfo&state=%s#wechat_redirect",
                        Constants.WeChatAppId,
                        webIdOpt.get(),
                        webIdOpt.get()
                );
            } else {
                //该文章不存在，跳转到错误界面
                return String.format("redirect:/customError?error=%s", URLEncoder.encode("文章不可用!", "UTF-8"));
            }
        } else {

            //通过微信授权获取到的CODE请求微信服务器获取到用户信息
            WxAccessToken accessToken = weChatService.getAccessToken(code.get());
            WxBaseUserInfo wxBaseUserInfo = weChatService.getBaseUserInfo(accessToken.getAccessToken(), accessToken.getOpenId());
            if (wxBaseUserInfo == null) {
                return String.format("redirect:/customError?error=%s", URLEncoder.encode("微信用户信息获取失败!", "UTF-8"));
            }
            Visitor visitor = visitorService.saveOrUpdateUserWxInfo(wxBaseUserInfo);

            model.addAttribute("visitorId", visitor.getId());
            //如果访客用户信息是null，则需要进行用户信息完善
            model.addAttribute("needComplete", visitor.getCompanyName() == null);

            Long webId = Long.parseLong(state.orElse("-1"));
            Optional<ProductWeb> productWebOptional = productWebService.findById(webId);
            if (!productWebOptional.isPresent()) {
                //该文章不存在，跳转到错误界面
                return String.format("redirect:/customError?error=%s", URLEncoder.encode("文章不可用!", "UTF-8"));
            } else {
                model.addAttribute("productWeb", productWebOptional.get());
                return "preview";
            }
        }
    }
}
