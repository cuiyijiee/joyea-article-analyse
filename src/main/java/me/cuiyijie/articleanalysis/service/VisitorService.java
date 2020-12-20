package me.cuiyijie.articleanalysis.service;

import me.cuiyijie.articleanalysis.dao.VisitorDao;
import me.cuiyijie.articleanalysis.entity.Visitor;
import me.cuiyijie.articleanalysis.entity.wx.WxBaseUserInfo;
import me.cuiyijie.articleanalysis.vo.ReqUpdateVisitorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

/**
 * @author cyj976655@gmail.com
 * @date 2020/12/20 17:29
 */

@Service
public class VisitorService {

    @Autowired
    VisitorDao visitorDao;

    public Visitor saveOrUpdateUserWxInfo(WxBaseUserInfo wxBaseUserInfo) {
        Visitor visitor = visitorDao.findByOpenId(wxBaseUserInfo.getOpenId());
        if (visitor == null) {
            visitor = new Visitor(
                    wxBaseUserInfo.getOpenId(),
                    wxBaseUserInfo.getNickName(),
                    wxBaseUserInfo.getHeadImgUrl());
        } else {
            visitor.setWxNickName(wxBaseUserInfo.getNickName());
            visitor.setWxHeadImage(wxBaseUserInfo.getHeadImgUrl());
            visitor.setUpdatedAt(OffsetDateTime.now());
        }
        return visitorDao.save(visitor);
    }

    public boolean saveUserInfo(ReqUpdateVisitorInfo reqUpdateVisitorInfo) {
        Optional<Visitor> visitorOptional = visitorDao.findById(reqUpdateVisitorInfo.getVisitorId());
        if (visitorOptional.isPresent()) {
            Visitor visitor = visitorOptional.get();
            visitor.setCompanyName(reqUpdateVisitorInfo.getCompanyName());
            visitor.setCompanyPosition(reqUpdateVisitorInfo.getPosition());
            visitor.setUserName(reqUpdateVisitorInfo.getName());
            visitor.setMobileNumber(reqUpdateVisitorInfo.getMobileNumber());
            visitor.setUpdatedAt(OffsetDateTime.now());
            visitorDao.save(visitor);
            return true;
        } else {
            return false;
        }
    }
}
