package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.out.AddressListOutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 14:46
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    /* *
     * 根据用户id查询地址信息
     * @return
     */
    @GetMapping("/getListByCustomerId")
    public List<AddressListOutDTO> getListByCustomerId(){
        return null;
    }
}
