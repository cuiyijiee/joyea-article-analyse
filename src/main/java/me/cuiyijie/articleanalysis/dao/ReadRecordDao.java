package me.cuiyijie.articleanalysis.dao;

import me.cuiyijie.articleanalysis.entity.ReadRecord;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 16:55
 */
@Repository
public interface ReadRecordDao extends PagingAndSortingRepository<ReadRecord, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT into read_record(web_id,visitor_id) VALUES(?1,?2)", nativeQuery = true)
    public void addRecordIdById(long webId, long visitorId);

}
