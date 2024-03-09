package me.cuiyijie.articleanalysis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 16:53
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "read_record")
public class ReadRecord {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "web_id",referencedColumnName = "id")
    private ProductWeb productWeb;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitor_id",referencedColumnName = "id")
    private Visitor visitor;

    @Column
    private OffsetDateTime createdAt;

    public ReadRecord(ProductWeb productWeb, Visitor visitor) {
        this.productWeb = productWeb;
        this.visitor = visitor;
        this.createdAt = OffsetDateTime.now();
    }
}
