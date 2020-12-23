package me.cuiyijie.articleanalysis.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import me.cuiyijie.articleanalysis.define.CommonResp;
import me.cuiyijie.articleanalysis.define.PageUtil;
import me.cuiyijie.articleanalysis.entity.ReadRecord;
import me.cuiyijie.articleanalysis.service.ReadRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 16:55
 */

@RestController
public class ReadRecordController {


    @Autowired
    private ReadRecordService readRecordService;

    @RequestMapping
    public String read() {
        return "";
    }

    @RequestMapping("/api/readRecord/add")
    public CommonResp<Boolean> addRecord(long visitorId, long webId) {
        readRecordService.addRecordById(webId, visitorId);
        return CommonResp.success(true);
    }

    @RequestMapping("/api/readRecord/all")
    public CommonResp<ReadRecord> findAll() {
        return CommonResp.success(readRecordService.findAll());
    }

    @RequestMapping("/api/readRecord/find")
    public CommonResp<PageUtil.PageResp> find(@RequestParam int current, @RequestParam(defaultValue = "10") int pageSize) {
        return CommonResp.success(readRecordService.pageFind(PageRequest.of(current, pageSize)));
    }

}
