package me.cuiyijie.articleanalysis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 16:35
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_web")
public class ProductWeb {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String webUrl;

    @Column
    private String webTitle;

    @Column
    private String productName;

    @Column
    private String productType;

    @Column
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime updatedAt;

    public ProductWeb(String webUrl, String webTitle, String productName, String productType) {
        this.webUrl = webUrl;
        this.webTitle = webTitle;
        this.productName = productName;
        this.productType = productType;
        this.createdAt = OffsetDateTime.now();
    }

}
