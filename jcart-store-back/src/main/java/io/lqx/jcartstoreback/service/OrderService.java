package io.lqx.jcartstoreback.service;

import com.github.pagehelper.Page;
import io.lqx.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.lqx.jcartstoreback.dto.out.OrderShowOutDTO;
import io.lqx.jcartstoreback.po.Order;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/6 13:24
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface OrderService {

    Long chekout(OrderCheckoutInDTO orderCheckoutInDTO,Integer customerId);

    OrderShowOutDTO getById(Long orderId);

    Page<Order> getByCustomerId(Integer pageNum, Integer customerId);
}
