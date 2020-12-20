package me.cuiyijie.articleanalysis.dao;

import me.cuiyijie.articleanalysis.entity.ReadRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 16:55
 */
public interface ReadRecordDao extends JpaRepository<ReadRecord, Long> {
}
