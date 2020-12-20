package me.cuiyijie.articleanalysis.entity;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 16:35
 */
@Entity
@Table(name = "product_web")
public class ProductWeb {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String webUrl;
    @Column
    public String webTitle;

    @Column
    public String productName;
    @Column
    public String productType;

    @Column
    public OffsetDateTime createdAt;
    @Column
    public OffsetDateTime updatedAt;

    public ProductWeb() {

    }

    public ProductWeb(String webUrl, String webTitle, String productName, String productType) {
        this.webUrl = webUrl;
        this.webTitle = webTitle;
        this.productName = productName;
        this.productType = productType;
        this.createdAt = OffsetDateTime.now();
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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
}
