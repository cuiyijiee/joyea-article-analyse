package me.cuiyijie.articleanalysis.define;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 20:21
 */
public class CommonResp<T> {
    public int code;
    public T data;

    public CommonResp(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public static CommonResp success(Object data) {
        return new CommonResp(2000, data);
    }

    public static CommonResp error(String error) {
        return new CommonResp(5000, error);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
