package me.cuiyijie.articleanalysis.entity;

import javax.persistence.*;

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


    @Column
    private Long webId;

    @Column
    private Long visitorId;

    public ReadRecord() {
    }

    public ReadRecord(Long webId, Long visitorId) {
        this.webId = webId;
        this.visitorId = visitorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWebId() {
        return webId;
    }

    public void setWebId(Long webId) {
        this.webId = webId;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    @Override
    public String toString() {
        return "ReadRecord{" +
                "id=" + id +
                ", webId=" + webId +
                ", visitorId=" + visitorId +
                '}';
    }
}
