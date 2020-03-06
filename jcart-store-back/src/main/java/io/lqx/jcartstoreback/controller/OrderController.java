package io.lqx.jcartstoreback.controller;

import io.lqx.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.lqx.jcartstoreback.dto.out.OrderListOutDTO;
import io.lqx.jcartstoreback.dto.out.OrderShowOutDTO;
import io.lqx.jcartstoreback.dto.out.PageOutDTO;
import io.lqx.jcartstoreback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 17:30
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /* *
     * 创建订单
     * @param orderCheckoutInDTO
     * @param customerId
     * @return
     */
    @PostMapping("/checkout")
    public Long checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        Long orderId = orderService.chekout(orderCheckoutInDTO, customerId);
        return orderId;
    }

    /* *
     * 查看订单信息
     * @param customerId
     * @return
     */
    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                               @RequestAttribute Integer customerId){
        return null;
    }

    /* *
     * 展示订单信息
     * @param orderId
     * @return
     */
    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }
}