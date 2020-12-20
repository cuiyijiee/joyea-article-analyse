package me.cuiyijie.articleanalysis.service;

import me.cuiyijie.articleanalysis.dao.ReadRecordDao;
import me.cuiyijie.articleanalysis.entity.ReadRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 18:02
 */

@Service
public class ReadRecordService {


    @Autowired
    private ReadRecordDao readRecordDao;

    public ReadRecord addReadRecord(Long webId, Long visitorId) {
        ReadRecord readRecord = new ReadRecord(webId, visitorId);
        return readRecordDao.save(readRecord);
    }
}
