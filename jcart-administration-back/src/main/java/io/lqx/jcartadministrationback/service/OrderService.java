package io.lqx.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.lqx.jcartadministrationback.dto.in.OrderSearchInDTO;
import io.lqx.jcartadministrationback.dto.out.OrderListOutDTO;
import io.lqx.jcartadministrationback.dto.out.OrderShowOutDTO;
import io.lqx.jcartadministrationback.po.Order;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/6 20:15
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface OrderService {

    Page<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO, Integer pageNum);

    OrderShowOutDTO getById(Long orderId);

    void update(Order order);

}
