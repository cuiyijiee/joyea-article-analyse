package me.cuiyijie.articleanalysis.entity.vo;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 20:19
 */
public class ReqSaveOrUpdateProductWeb {

    private Long id;
    private String webUrl;
    private String webTitle;
    private String productType;
    private String productName;


    public ReqSaveOrUpdateProductWeb(Long id, String webUrl, String webTitle, String productType, String productName) {
        this.id = id;
        this.webUrl = webUrl;
        this.webTitle = webTitle;
        this.productType = productType;
        this.productName = productName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
