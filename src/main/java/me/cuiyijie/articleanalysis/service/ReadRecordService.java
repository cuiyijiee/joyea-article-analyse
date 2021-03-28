package me.cuiyijie.articleanalysis.service;

import me.cuiyijie.articleanalysis.dao.ReadRecordDao;
import me.cuiyijie.articleanalysis.define.PageUtil;
import me.cuiyijie.articleanalysis.entity.ProductWeb;
import me.cuiyijie.articleanalysis.entity.ReadRecord;
import me.cuiyijie.articleanalysis.entity.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 18:02
 */

@Service
public class ReadRecordService {


    @Autowired
    private ReadRecordDao readRecordDao;

    public void addRecordById(long webId, long visitorId) {
        readRecordDao.addRecordIdById(webId, visitorId);
    }

    public ReadRecord addReadRecord(ProductWeb productWeb, Visitor visitorId) {
        ReadRecord readRecord = new ReadRecord(productWeb, visitorId);
        return readRecordDao.save(readRecord);
    }

    public PageUtil.PageResp<ReadRecord> pageFind(Pageable pageable) {
        return PageUtil.convertFromPage(readRecordDao.findAll(pageable));
    }

    public List<ReadRecord> findAll() {
        return (List<ReadRecord>) readRecordDao.findAll(Sort.by("createdAt").descending());
    }

    public void deleteByWebId(long webId){
        readRecordDao.deleteByWebId(webId);
    }
}
