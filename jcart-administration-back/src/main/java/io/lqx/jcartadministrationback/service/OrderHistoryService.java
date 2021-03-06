package io.lqx.jcartadministrationback.service;

import io.lqx.jcartadministrationback.po.OrderHistory;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/9 14:16
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);

    Long create(OrderHistory orderHistory);
}
