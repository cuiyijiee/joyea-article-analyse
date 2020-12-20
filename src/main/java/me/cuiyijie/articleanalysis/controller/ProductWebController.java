package me.cuiyijie.articleanalysis.controller;

import me.cuiyijie.articleanalysis.dao.ProductWebDao;
import me.cuiyijie.articleanalysis.define.CommonResp;
import me.cuiyijie.articleanalysis.define.PageUtil;
import me.cuiyijie.articleanalysis.entity.ProductWeb;
import me.cuiyijie.articleanalysis.service.ReadRecordService;
import me.cuiyijie.articleanalysis.vo.ReqSaveOrUpdateProductWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/19 16:45
 */

@Controller
public class ProductWebController {

    @Autowired
    public ProductWebDao productWebDao;

    @Autowired
    public ReadRecordService readRecordService;

    @ResponseBody
    @PostMapping("api/productWeb/create")
    public CommonResp create(@RequestBody ReqSaveOrUpdateProductWeb req) {
        ProductWeb productWeb = new ProductWeb(
                req.getWebUrl(),
                req.getWebTitle(),
                req.getProductName(),
                req.getProductType()
        );
        return CommonResp.success(productWebDao.save(productWeb));
    }

    @ResponseBody
    @PostMapping("api/productWeb/update")
    public CommonResp update(@RequestBody ReqSaveOrUpdateProductWeb req) {
        Optional<ProductWeb> productWebOpt = productWebDao.findById(req.getId());
        if (productWebOpt.isPresent()) {
            ProductWeb productWeb = productWebOpt.get();
            productWeb.setWebUrl(req.getWebUrl());
            productWeb.setWebTitle(req.getWebTitle());
            productWeb.setProductType(req.getProductType());
            productWeb.setProductName(req.getProductName());
            return CommonResp.success(productWebDao.save(productWeb));
        } else {
            return CommonResp.error("to update record not found!");
        }
    }

    @ResponseBody
    @RequestMapping("api/productWeb/find")
    public CommonResp<PageUtil.PageResp> pageFind(@RequestParam int current, @RequestParam(defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(current, pageSize, Sort.by("createdAt").descending());
        return CommonResp.success(PageUtil.convertFromPage(productWebDao.findAll(pageable)));
    }

    @ResponseBody
    @DeleteMapping("api/productWeb/delete")
    public CommonResp delete(@RequestParam Long id) {
        productWebDao.deleteById(id);
        return CommonResp.success(true);
    }

    @RequestMapping("read")
    public String read(Model model, @RequestParam String webUrl) {
        model.addAttribute("articleUrl",webUrl);
        return "read";
    }
}
