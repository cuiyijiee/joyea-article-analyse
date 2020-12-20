package me.cuiyijie.articleanalysis.define;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 17:35
 */
public class Constants {

    public static final String WeChatAppId = "wxfb30c83cd3bb2626";
    public static final String WeChatSecret = "a6c89890b074b1e488080ba9e7b3e8f5";


    public static final String WeChatAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    public static String getWeChatAccessTokenUrl(String code) {
        return String.format(WeChatAccessTokenUrl, WeChatAppId, WeChatSecret, code);
    }
}
