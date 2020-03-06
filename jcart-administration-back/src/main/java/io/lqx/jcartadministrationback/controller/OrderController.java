package io.lqx.jcartadministrationback.controller;

import com.github.pagehelper.Page;
import io.lqx.jcartadministrationback.dto.in.OrderSearchInDTO;
import io.lqx.jcartadministrationback.dto.out.*;
import io.lqx.jcartadministrationback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 14:53
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
     * 查询订单信息
     * @param orderSearchInDTO
     * @param orderId
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,
                                               @RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<OrderListOutDTO> page = orderService.search(pageNum);
        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);
        return pageOutDTO;
    }

    /* *
     * 订单信息展示
     * @param orderId
     * @return
     */
    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        OrderShowOutDTO orderShowOutDTO = orderService.getById(orderId);
        return orderShowOutDTO;
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
