package io.lqx.jcartadministrationback.service.impl;

import io.lqx.jcartadministrationback.dao.ReturnHistoryMapper;
import io.lqx.jcartadministrationback.po.Return;
import io.lqx.jcartadministrationback.po.ReturnHistory;
import io.lqx.jcartadministrationback.service.ReturnHistoryService;
import io.lqx.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/9 19:47
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Autowired
    private ReturnService returnService;

    @Override
    public List<ReturnHistory> getListByReturnId(Integer returnId) {
        List<ReturnHistory> returnHistories = returnHistoryMapper.selectList(returnId);
        return returnHistories;
    }

    @Override
    @Transactional
    public Long create(ReturnHistory returnHistory) {
        returnHistoryMapper.insertSelective(returnHistory);
        Long returnHistoryId = returnHistory.getReturnHistoryId();

        Return returns = new Return();
        returns.setReturnId(returnHistory.getReturnId());
        returns.setUpdateTime(new Date());
        returnService.update(returns);
        return returnHistoryId;
    }
}
