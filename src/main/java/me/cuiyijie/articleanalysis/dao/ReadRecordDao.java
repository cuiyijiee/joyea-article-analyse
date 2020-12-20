package me.cuiyijie.articleanalysis.dao;

import me.cuiyijie.articleanalysis.entity.ReadRecord;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 16:55
 */
public interface ReadRecordDao extends PagingAndSortingRepository<ReadRecord, Long> {
}
