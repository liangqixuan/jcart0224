package io.lqx.jcartstoreback.controller;

import io.lqx.jcartstoreback.dto.in.*;
import io.lqx.jcartstoreback.dto.out.CustomerGetProfileOutDTO;
import io.lqx.jcartstoreback.po.Customer;
import io.lqx.jcartstoreback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 17:012
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
    private JWTUtil jwtUtil;

    /* *
     * 前台商店端用户注册
     * @param customerRegisterInDTO
     * @return
     */
    @PostMapping("/register")
    public Integer register(@RequestBody CustomerRegisterInDTO customerRegisterInDTO){
        Customer customer = customerService.getByUsername(customerLoginInDTO.getUsername());
        return null;
    }

    /* *
     * 前台商店端用户登录
     * @param customerLoginInDTO
     * @return
     */
    @GetMapping("/login")
    public String login(CustomerLoginInDTO customerLoginInDTO){
        return null;
    }

    /* *
     * 前台商店端获取用户
     * @param customerId
     * @return
     */
    @GetMapping("/getProfile")
    public CustomerGetProfileOutDTO getProfile(@RequestAttribute Integer customerId){
        return null;
    }

    /* *
     * 前台商店端更新用户
     * @param customerUpdateProfileInDTO
     * @param customerId
     */
    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody CustomerUpdateProfileInDTO customerUpdateProfileInDTO,
                              @RequestAttribute Integer customerId){

    }

    /* *
     * 前台商店端修改密码
     * @param customerChangePwdInDTO
     * @param customerId
     */
    @PostMapping("/changePwd")
    public void changePwd(@RequestBody CustomerChangePwdInDTO customerChangePwdInDTO,
                          @RequestAttribute Integer customerId){

    }

    @GetMapping("/getPwdResetCode")
    public String getPwdResetCode(@RequestParam String email){
        return null;
    }

    @PostMapping("/resetPwd")
    public void resetPwd(@RequestBody CustomerResetPwdInDTO customerResetPwdInDTO){

    }



}