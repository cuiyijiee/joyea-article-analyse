package me.cuiyijie.articleanalysis.entity.wx;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信错误返回
 */
public class WxError {


    @JsonProperty("errcode")
    private Integer errCode;

    @JsonProperty("errmsg")
    private String errMsg;

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

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