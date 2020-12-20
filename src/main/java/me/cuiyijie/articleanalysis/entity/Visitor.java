package me.cuiyijie.articleanalysis.entity;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 16:48
 */
@Entity
@Table(name = "visitor")
public class Visitor {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    private String wxOpenId;
    @Column
    private String wxNickName;
    @Column
    private String wxHeadImage;
    @Column
    private String companyName;
    @Column
    private String companyPosition;
    @Column
    private String userName;
    @Column
    private String mobileNumber;
    @Column
    private OffsetDateTime createdAt;
    @Column
    private OffsetDateTime updatedAt;


    public Visitor() {
    }

    public Visitor(String wxOpenId, String wxNickName, String wxHeadImage) {
        this.wxOpenId = wxOpenId;
        this.wxNickName = wxNickName;
        this.wxHeadImage = wxHeadImage;
        this.createdAt = OffsetDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getWxNickName() {
        return wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    public String getWxHeadImage() {
        return wxHeadImage;
    }

    public void setWxHeadImage(String wxHeadImage) {
        this.wxHeadImage = wxHeadImage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPosition() {
        return companyPosition;
    }

    public void setCompanyPosition(String companyPosition) {
        this.companyPosition = companyPosition;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", wxNickName='" + wxNickName + '\'' +
                ", wxHeadImage='" + wxHeadImage + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyPosition='" + companyPosition + '\'' +
                ", userName='" + userName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
