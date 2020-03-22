package io.lqx.jcartstoreback.service.impl;

import io.lqx.jcartstoreback.dao.ProductOperationMapper;
import io.lqx.jcartstoreback.po.ProductOperation;
import io.lqx.jcartstoreback.service.ProductOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/22 11:01
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Service
public class ProductOperationServiceImpl implements ProductOperationService {

    @Autowired
    private ProductOperationMapper productOperationMapper;

    @Override
    public void count(Integer productId) {
        ProductOperation productOperation = productOperationMapper.selectByPrimaryKey(productId);

        if(productOperation == null){
            ProductOperation pro = new ProductOperation();
            pro.setProductId(productId);
            pro.setAllCount(1);
            pro.setDayCount(1);
            pro.setRecentTime(new Date());
            productOperationMapper.insertSelective(pro);
        }else{
            productOperation.setAllCount(productOperation.getAllCount()+1);
            productOperation.setDayCount(productOperation.getAllCount()+1);
            productOperation.setRecentTime(new Date());
            productOperationMapper.updateByPrimaryKeySelective(productOperation);
        }
    }
}
