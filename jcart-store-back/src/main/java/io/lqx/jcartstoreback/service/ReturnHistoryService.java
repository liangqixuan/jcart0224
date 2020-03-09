package io.lqx.jcartstoreback.service;

import io.lqx.jcartstoreback.po.ReturnHistory;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/9 21:50
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface ReturnHistoryService {
    List<ReturnHistory> getByReturnId(Integer returnId);
}
