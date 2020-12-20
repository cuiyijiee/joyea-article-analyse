package me.cuiyijie.articleanalysis.entity.vo;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 18:52
 */
public class ReqUpdateVisitorInfo {

    private Long visitorId;
    private String companyName;
    private String position;
    private String name;
    private String mobileNumber;

    public ReqUpdateVisitorInfo() {
    }

    public ReqUpdateVisitorInfo(Long visitorId, String companyName, String position, String name, String mobileNumber) {
        this.visitorId = visitorId;
        this.companyName = companyName;
        this.position = position;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
