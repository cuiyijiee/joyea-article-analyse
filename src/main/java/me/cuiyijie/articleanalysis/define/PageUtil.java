package me.cuiyijie.articleanalysis.define;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 18:31
 */
public class PageUtil {

    public static <T> PageResp<T> convertFromPage(Page<T> page) {
        return new PageResp<>(page.getTotalElements(),
                page.getPageable().getPageNumber(),
                page.getPageable().getPageSize(),
                page.getContent());
    }

    @Data
    @AllArgsConstructor
    public static class PageResp<T> {

        public Long total;
        public Integer current;
        public Integer pageSize;

        public List<T> data;

    }
}
