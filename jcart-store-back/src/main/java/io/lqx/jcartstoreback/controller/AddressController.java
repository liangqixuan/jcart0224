package io.lqx.jcartstoreback.controller;

import io.lqx.jcartstoreback.dto.in.AddressCreateInDTO;
import io.lqx.jcartstoreback.dto.in.AddressUpdateInDTO;
import io.lqx.jcartstoreback.dto.out.AddressListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 17:08
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @GetMapping("/getAddressByCustomerId")
    public List<AddressListOutDTO> getAddressByCustomerId(@RequestAttribute Integer customerId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AddressCreateInDTO addressCreateInDTO,
                          @RequestAttribute Integer customerId){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody AddressUpdateInDTO addressUpdateInDTO,
                       @RequestAttribute Integer customerId){
        
    }

    @PostMapping
    public void delete(@RequestBody Integer addressId){

    }

}