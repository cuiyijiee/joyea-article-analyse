package me.cuiyijie.articleanalysis.service;

import lombok.extern.slf4j.Slf4j;
import me.cuiyijie.articleanalysis.define.Constants;
import me.cuiyijie.articleanalysis.entity.wx.WxAccessToken;
import me.cuiyijie.articleanalysis.entity.wx.WxBaseUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 15:31
 */
@Slf4j
@Service
public class WeChatService {

    private final static String GetAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
            "appid={appid}&secret={secret}&code={code}&grant_type={grant_type}";

    private final static String GetUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
            "access_token={access_token}&openid={openid}&lang={lang}";

    @Autowired
    RestTemplate restTemplate;

    public WxAccessToken getAccessToken(String code) {
        Map<String, String> postData = new HashMap<>();
        postData.put("appid", Constants.WeChatAppId);
        postData.put("secret", Constants.WeChatSecret);
        postData.put("code", code);
        postData.put("grant_type", "authorization_code");
        WxAccessToken accessToken = restTemplate.getForObject(GetAccessTokenUrl, WxAccessToken.class, postData);
        log.info("【wechat】get access token: {}", accessToken);
        return accessToken;
    }

    public WxBaseUserInfo getBaseUserInfo(String accessToken, String openId) {

        Map<String, String> params = new HashMap<>();
        params.put("access_token", accessToken);
        params.put("openid", openId);
        params.put("lang", "zh_CN");
        WxBaseUserInfo result = null;
        try {
            result = restTemplate.getForObject(GetUserInfoUrl, WxBaseUserInfo.class, params);
            log.info("【wechat】get base user info: {}", result);
            if (null == result || !result.valid()) {
                result = null;
            }
        } catch (RestClientException exception) {
            log.error("【wechat】get base user info:", exception);
        }
        return result;
    }

}
