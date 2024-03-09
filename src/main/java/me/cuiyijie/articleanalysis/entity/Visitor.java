package me.cuiyijie.articleanalysis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 16:48
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "visitor")
public class Visitor {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public Visitor(String wxOpenId, String wxNickName, String wxHeadImage) {
        this.wxOpenId = wxOpenId;
        this.wxNickName = wxNickName;
        this.wxHeadImage = wxHeadImage;
        this.createdAt = OffsetDateTime.now();
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
