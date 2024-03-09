package me.cuiyijie.articleanalysis.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 18:52
 */
@Data
@AllArgsConstructor
public class ReqUpdateVisitorInfo {

    private Long visitorId;
    private String companyName;
    private String position;
    private String name;
    private String mobileNumber;

}
