package me.cuiyijie.articleanalysis.entity.vo;

import lombok.Data;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 20:19
 */
@Data
public class ReqSaveOrUpdateProductWeb {

    private Long id;
    private String webUrl;
    private String webTitle;
    private String productType;
    private String productName;

}
