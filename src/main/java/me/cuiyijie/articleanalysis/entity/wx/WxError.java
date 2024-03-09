package me.cuiyijie.articleanalysis.entity.wx;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 微信错误返回
 */
@Data
public class WxError {


    @JsonProperty("errcode")
    private Integer errCode;

    @JsonProperty("errmsg")
    private String errMsg;

    @Override
    public String toString() {
        return "WxError{" +
                "errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }

    //---------- functions

    public boolean valid(){
        return errCode == null || errCode == 0;
    }

}