package io.lqx.jcartstoreback.service;

import io.lqx.jcartstoreback.po.ProductOperation;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/22 11:00
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface ProductOperationService {

    void count(Integer productId);

    List<ProductOperation> selectHotProduct();
}
