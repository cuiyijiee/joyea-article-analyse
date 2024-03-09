package me.cuiyijie.articleanalysis.entity.wx;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 15:33
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxBaseUserInfo extends WxError implements Serializable {

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("nickname")
    private String nickName;

    //用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
    private Integer sex;

    private String province;

    private String city;

    private String country;

    @JsonProperty("headimgurl")
    private String headImgUrl;

    private List<String> privilege;// tag8

    @JsonProperty("unionid")
    private String unionId;


    @Override
    public String toString() {
        return "WxBaseUserInfo{" +
                "openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", privilege=" + privilege +
                ", unionId='" + unionId + '\'' +
                ", errorMsg='" + getErrMsg() + '\'' +
                ", errorCode='" + getErrCode() + '\'' +
                '}';
    }
}
