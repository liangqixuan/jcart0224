package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.in.*;
import io.lqx.jcartadministrationback.dto.out.AdministratorGetProfileOutDTO;
import io.lqx.jcartadministrationback.dto.out.AdministratorListOutDTO;
import io.lqx.jcartadministrationback.dto.out.AdministratorShowOutDTO;
import io.lqx.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public AdministratorGetProfileOutDTO getProfile(@RequestParam(required = false) Integer administratorId){
        return null;
    }

    /* *
     * 用户更新
     */
    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){

    }

    /* *
     * 验证密码
     * @param email
     * @return
     */
    @GetMapping("/getPwdRestCode")
    public String getPwdRestCode(@RequestParam String email){
        return null;
    }

    /* *
     * 重置密码
     */
    @PostMapping("/restPws")
    public void restPws(@RequestBody AdministratorRestPwdInDTO administratorRestPwdInDTO){

    }

    /* *
     * 列表查询
     * @param page
     * @return
     */
    @GetMapping("/getList")
    public PageOutDTO<AdministratorListOutDTO> getList(@RequestParam Integer pageNum){
        return null;
    }

    /* *
     * 信息展示
     * @param administratorId
     * @return
     */
    @GetMapping("/getById")
    public AdministratorShowOutDTO getById(@RequestParam Integer administratorId){
        return null;
    }

    /* *
     * 创建信息
     * @param administratorCreateInDTO
     * @return
     */
    @PostMapping("/create")
    public Integer create(@RequestBody AdministratorCreateInDTO administratorCreateInDTO){
        return 0;
    }

    /* *
     * 更新信息
     */
    @PostMapping("/update")
    public void update(@RequestBody AdministratorUpdateInDTO administratorUpdateInDTO){

    }

    /* *
     * 单挑信息删除
     * @param administratorId
     */
    @PostMapping("/delete")
    public void delete(@RequestBody Integer administratorId){

    }

    /* *
     * 批量删除信息
     * @param administratorIds
     */
    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> administratorIds){

    }
}
