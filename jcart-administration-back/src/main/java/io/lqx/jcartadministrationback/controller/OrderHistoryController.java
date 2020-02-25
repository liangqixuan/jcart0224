package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.in.OrderHistoryCreateInDTO;
import io.lqx.jcartadministrationback.dto.out.OrderHistoryListOutDTO;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 15:36
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/orderhistory")
public class OrderHistoryController {

    /* *
     * 查询订单历史信息
     * @param orderId
     * @return
     */
    @GetMapping("/getListByOrderId")
    public List<OrderHistoryListOutDTO> getListByOrderId(@RequestParam Long orderId){
        return null;
    }

    /* *
     * 添加订单历史
     * @return
     */
    @PostMapping("/create")
    public Integer create(@RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO){
        return 0;
    }
}
