package io.lqx.jcartstoreback.controller;

import io.lqx.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.lqx.jcartstoreback.dto.out.OrderListOutDTO;
import io.lqx.jcartstoreback.dto.out.OrderShowOutDTO;
import io.lqx.jcartstoreback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 17:30
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/checkout")
    public Integer checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }
}