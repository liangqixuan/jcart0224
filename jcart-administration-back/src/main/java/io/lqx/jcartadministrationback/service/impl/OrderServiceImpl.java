package io.lqx.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.lqx.jcartadministrationback.dao.OrderMapper;
import io.lqx.jcartadministrationback.dto.out.OrderListOutDTO;
import io.lqx.jcartadministrationback.dto.out.OrderShowOutDTO;
import io.lqx.jcartadministrationback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/6 20:15
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Page<OrderListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<OrderListOutDTO> page = orderMapper.search();
        return page;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        return null;
    }
}
