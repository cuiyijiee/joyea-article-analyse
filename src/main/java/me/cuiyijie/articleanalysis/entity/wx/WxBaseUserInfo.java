package me.cuiyijie.articleanalysis.entity.wx;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 15:33
 */
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public List<String> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(List<String> privilege) {
        this.privilege = privilege;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }


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
                '}';
    }
}
