package io.lqx.jcartstoreback.service.impl;

import io.lqx.jcartstoreback.po.ReturnHistory;
import io.lqx.jcartstoreback.service.ReturnHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/9 21:52
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {
    @Override
    public List<ReturnHistory> getByReturnId(Integer returnId) {
        return null;
    }
}
