package me.cuiyijie.articleanalysis.service;

import me.cuiyijie.articleanalysis.dao.ProductWebDao;
import me.cuiyijie.articleanalysis.entity.ProductWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 17:40
 */

@Service
public class ProductWebService {

    @Autowired
    ProductWebDao productWebDao;

    public Optional<ProductWeb> findById(Long id) {
        return productWebDao.findById(id);
    }

}
