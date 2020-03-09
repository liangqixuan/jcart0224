package io.lqx.jcartstoreback.service;

import com.github.pagehelper.Page;
import io.lqx.jcartstoreback.po.Return;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/9 21:13
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface ReturnService {

    Integer create(Return aReturn);

    Page<Return> getPageByCustomerId(Integer customerId, Integer pageNum);

    Return getById(Integer returnId);
}
