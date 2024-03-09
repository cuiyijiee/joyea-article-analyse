package me.cuiyijie.articleanalysis.entity.wx;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 17:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxAccessToken extends WxError implements Serializable {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private int expiresIn;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("openid")
    private String openId;

    private String scope;

    @JsonProperty("is_snapshotuser")
    private int isSnapshotuser;

    @Override
    public String toString() {
        return "WxAccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", refreshToken='" + refreshToken + '\'' +
                ", openId='" + openId + '\'' +
                ", scope='" + scope + '\'' +
                ", is_snapshotuser='" + isSnapshotuser + '\'' +
                '}';
    }
}
