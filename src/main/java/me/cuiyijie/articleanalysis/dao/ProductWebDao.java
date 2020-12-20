package me.cuiyijie.articleanalysis.dao;

import me.cuiyijie.articleanalysis.entity.ProductWeb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 16:41
 */
public interface ProductWebDao extends PagingAndSortingRepository<ProductWeb, Long> {

    @Override
    Page<ProductWeb> findAll(Pageable pageable);
}
