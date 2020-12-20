package me.cuiyijie.articleanalysis.dao;

import me.cuiyijie.articleanalysis.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 16:51
 */
public interface VisitorDao extends JpaRepository<Visitor, Long>, JpaSpecificationExecutor<Visitor> {

    @Query(value = "SELECT v FROM Visitor v WHERE v.wxOpenId=?1")
    public Visitor findByOpenId(String openId);
}
