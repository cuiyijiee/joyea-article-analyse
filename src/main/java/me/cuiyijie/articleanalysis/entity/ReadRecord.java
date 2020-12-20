package me.cuiyijie.articleanalysis.entity;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 16:53
 */
@Entity
@Table(name = "read_record")
public class ReadRecord {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "web_id",referencedColumnName = "id")
    private ProductWeb productWeb;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitor_id",referencedColumnName = "id")
    private Visitor visitor;

    @Column
    private OffsetDateTime createdAt;

    public ReadRecord() {
    }

    public ReadRecord(ProductWeb productWeb, Visitor visitor) {
        this.productWeb = productWeb;
        this.visitor = visitor;
        this.createdAt = OffsetDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductWeb getProductWeb() {
        return productWeb;
    }

    public void setProductWeb(ProductWeb productWeb) {
        this.productWeb = productWeb;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
