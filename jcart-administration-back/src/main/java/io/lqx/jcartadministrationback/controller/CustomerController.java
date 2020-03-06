package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.in.CustomerSearchInDTO;
import io.lqx.jcartadministrationback.dto.out.CustomerListOutDTO;
import io.lqx.jcartadministrationback.dto.out.CustomerShowOutDTO;
import io.lqx.jcartadministrationback.dto.out.PageOutDTO;
import io.lqx.jcartadministrationback.po.Address;
import io.lqx.jcartadministrationback.po.Customer;
import io.lqx.jcartadministrationback.service.AddressService;
import io.lqx.jcartadministrationback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 14:30
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

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
        Customer customer = customerService.getById(customerId);

        CustomerShowOutDTO customerShowOutDTO = new CustomerShowOutDTO();
        customerShowOutDTO.setCustomerId(customerId);
        customerShowOutDTO.setUsername(customer.getUsername());
        customerShowOutDTO.setRealName(customer.getRealName());
        customerShowOutDTO.setMobile(customer.getMobile());
        customerShowOutDTO.setEmail(customer.getEmail());
        customerShowOutDTO.setAvatarUrl(customer.getAvatarUrl());
        customerShowOutDTO.setStatus(customer.getStatus());
        customerShowOutDTO.setRewordPoints(customer.getRewordPoints());
        customerShowOutDTO.setNewsSubscribed(customer.getNewsSubscribed());
        customerShowOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
        customerShowOutDTO.setDefaultAddressId(customer.getDefaultAddressId());

        // 获取用户地址信息
        Address defaultAddress = addressService.getById(customer.getDefaultAddressId());
        if (defaultAddress != null){
            customerShowOutDTO.setDefaultAddress(defaultAddress.getContent());
        }

        return customerShowOutDTO;
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
