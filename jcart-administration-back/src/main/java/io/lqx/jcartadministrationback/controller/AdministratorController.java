package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.in.AdministratorLoginInDTO;
import io.lqx.jcartadministrationback.dto.in.AdministratorUpdateProfileInDTO;
import io.lqx.jcartadministrationback.dto.out.AdministratorGetProfileOutDTO;
import org.springframework.web.bind.annotation.*;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/24 17:16
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    /* *
     * 用户登录
     * @return
     */
    @GetMapping("/login")
    public String login(AdministratorLoginInDTO administratorLoginInDTO){
        return null;
    }

    /* *
     * 获取用户登录里面的token值
     * @param administratorId
     * @return
     */
    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(Integer administratorId){
        return null;
    }

    /* *
     * 用户更新
     */
    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){

    }
}
