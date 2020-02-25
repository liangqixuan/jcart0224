package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.in.CustomerSearchInDTO;
import io.lqx.jcartadministrationback.dto.out.CustomerListOutDTO;
import io.lqx.jcartadministrationback.dto.out.CustomerShowOutDTO;
import io.lqx.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 14:30
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    /* *
     * 客户查询信息
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO>search(CustomerSearchInDTO customerSearchInDTO,
                                                @RequestParam Integer pageNum){
        return null;
    }

    /* *
     * 客户信息详情
     * @param customerId
     * @return
     */
    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        return null;
    }

    /* *
     * 客户禁用
     * @param customerId
     * @return
     */
    @PostMapping("/disable")
    public Integer disable(@RequestParam Integer customerId){
        return 0;
    }
}
