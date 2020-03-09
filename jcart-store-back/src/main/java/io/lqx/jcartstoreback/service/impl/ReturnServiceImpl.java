package io.lqx.jcartstoreback.service.impl;

import com.github.pagehelper.Page;
import io.lqx.jcartstoreback.dao.ReturnMapper;
import io.lqx.jcartstoreback.po.Return;
import io.lqx.jcartstoreback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/9 21:39
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Service

public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Integer create(Return aReturn) {
        return null;
    }

    @Override
    public Page<Return> getPageByCustomerId(Integer customerId, Integer pageNum) {
        return null;
    }

    @Override
    public Return getById(Integer returnId) {
        return null;
    }
}
