package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.in.OrderSearchInDTO;
import io.lqx.jcartadministrationback.dto.out.OrderInvoiceShowOutDTO;
import io.lqx.jcartadministrationback.dto.out.OrderShipShowOutDTO;
import io.lqx.jcartadministrationback.dto.out.OrderShowOutDTO;
import io.lqx.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 14:53
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /* *
     * 查询订单信息
     * @param orderSearchInDTO
     * @param orderId
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<OrderSearchInDTO> search(OrderSearchInDTO orderSearchInDTO,
                                               @RequestParam Integer orderId){
        return null;
    }

    /* *
     * 订单信息展示
     * @param orderId
     * @return
     */
    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }

    /* *
     * 发票信息
     * @param orderId
     * @return
     */
    @GetMapping("/getInvoiceInfo")
    public OrderInvoiceShowOutDTO getInvoiceInfo(@RequestParam Long orderId){
        return null;
    }

    /* *
     * 运送信息
     * @param orderId
     * @return
     */
    @GetMapping("/getShipInfo")
    public OrderShipShowOutDTO getShipInfo(@RequestParam Long orderId){
        return null;
    }
}
