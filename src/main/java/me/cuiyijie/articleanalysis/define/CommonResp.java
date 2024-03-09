package me.cuiyijie.articleanalysis.define;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 20:21
 */
@Data
@AllArgsConstructor
public class CommonResp<T> {
    public int code;
    public T data;

    public static <T> CommonResp<T> success(T data) {
        return new CommonResp<>(2000, data);
    }

    public static CommonResp<String> error(String error) {
        return new CommonResp<>(5000, error);
    }

}
