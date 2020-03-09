package io.lqx.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.lqx.jcartadministrationback.dto.in.ReturnSearchInDTO;
import io.lqx.jcartadministrationback.po.Return;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/9 19:25
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface ReturnService {

    Page<Return> search(ReturnSearchInDTO returnSearchInDTO, Integer pageNum);

    Return getById(Integer returnId);

    void update(Return aReturn);
}
