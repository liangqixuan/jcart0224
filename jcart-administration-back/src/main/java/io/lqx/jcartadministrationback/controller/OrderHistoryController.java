package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.in.OrderHistoryCreateInDTO;
import io.lqx.jcartadministrationback.dto.out.OrderHistoryListOutDTO;
import io.lqx.jcartadministrationback.po.OrderHistory;
import io.lqx.jcartadministrationback.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 15:36
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/orderhistory")
@CrossOrigin
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;

    /* *
     * 查询订单历史信息
     * @param orderId
     * @return
     */
    @GetMapping("/getListByOrderId")
    public List<OrderHistoryListOutDTO> getListByOrderId(@RequestParam Long orderId){
        List<OrderHistory> orderList = orderHistoryService.getByOrderId(orderId);

        List<OrderHistoryListOutDTO> list = orderList.stream().map(orderHistory -> {
            OrderHistoryListOutDTO order = new OrderHistoryListOutDTO();
            order.setOrderHistoryId(orderHistory.getOrderHistoryId());
            order.setTimestamp(orderHistory.getTime().getTime());
            order.setOrderStatus(orderHistory.getOrderStatus());
            order.setComment(orderHistory.getComment());
            orderHistory.setCustomerNotified(orderHistory.getCustomerNotified());
            return order;
        }).collect(Collectors.toList());

        return list;
    }

    /* *
     * 添加订单历史
     * @return
     */
    @PostMapping("/create")
    public Long create(@RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO){
        OrderHistory order = new OrderHistory();
        order.setOrderId(orderHistoryCreateInDTO.getOrderId());
        order.setTime(new Date());
        order.setOrderStatus(orderHistoryCreateInDTO.getOrderStatus());
        order.setComment(orderHistoryCreateInDTO.getComment());
        order.setCustomerNotified(orderHistoryCreateInDTO.getCustomerNotfied());

        Long orderId = orderHistoryService.create(order);

        return orderId;

    }
}
