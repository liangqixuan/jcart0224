package io.lqx.jcartadministrationback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.github.pagehelper.Page;
import io.lqx.jcartadministrationback.constant.ClientExceptionConstant;
import io.lqx.jcartadministrationback.dto.in.*;
import io.lqx.jcartadministrationback.dto.out.*;
import io.lqx.jcartadministrationback.enumeration.AdministratorStatus;
import io.lqx.jcartadministrationback.exception.ClientException;
import io.lqx.jcartadministrationback.po.Administrator;
import io.lqx.jcartadministrationback.service.AdministratorService;
import io.lqx.jcartadministrationback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/24 17:16
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/administrator")
@CrossOrigin
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private JWTUtil jwtUtil;

    /* *
     * 用户登录，jwt json web
     * @return
     */
    @GetMapping("/login")
    public AdministratorLoginOutDTO login(AdministratorLoginInDTO administratorLoginInDTO) throws ClientException {
        Administrator administrator = administratorService.getByUsername(administratorLoginInDTO.getUsername());
        if (administrator == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRMSG);
        }
        String encPwdDB = administrator.getEncryptedPassword();
        // 加密算法
        BCrypt.Result result = BCrypt.verifyer().verify(administratorLoginInDTO.getPassword().toCharArray(), encPwdDB);

        if (result.verified) {
            AdministratorLoginOutDTO administratorLoginOutDTO = jwtUtil.issueToken(administrator);
            return administratorLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRMSG);
        }
    }

    /* *
     * 获取管理员登录里面的数据,根据token获取
     * @param administratorId
     * @return
     */
    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(@RequestAttribute Integer administratorId){
        Administrator administrator = administratorService.getById(administratorId);

        AdministratorGetProfileOutDTO administrator1 = new AdministratorGetProfileOutDTO();
        administrator1.setAdminstratorId(administrator.getAdministratorId());
        administrator1.setUsername(administrator.getUsername());
        administrator1.setRealName(administrator.getRealName());
        administrator1.setEmail(administrator.getEmail());
        administrator1.setAvatarUrl(administrator.getAvatarUrl());
        administrator1.setCreateTimestamp(administrator.getCreateTime().getTime());
        return administrator1;
    }

    /* *
     * 用户更新,adminstratorId是从token解析出的
     */
    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO,
                              @RequestAttribute Integer administratorId){
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(administratorId);
        administrator.setRealName(administratorUpdateProfileInDTO.getRealName());
        administrator.setEmail(administratorUpdateProfileInDTO.getEmail());
        administrator.setAvatarUrl(administratorUpdateProfileInDTO.getAvatarUrl());
        administratorService.update(administrator);
    }

    /* *
     * 改变密码
     * @param administratorChangePwdInDTO
     * @param administratorId
     */
    @PostMapping("/changePed")
    public void changePwd(@RequestBody AdministratorChangePwdInDTO administratorChangePwdInDTO,
                          @RequestAttribute Integer administratorId){

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
    public PageOutDTO<AdministratorListOutDTO> getList(@RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<Administrator> page = administratorService.getList(pageNum);

        List<AdministratorListOutDTO> list = page.stream().map(administrator -> {
            AdministratorListOutDTO alo = new AdministratorListOutDTO();
            alo.setAdministratorId(administrator.getAdministratorId());
            alo.setRealName(administrator.getRealName());
            alo.setStatus(administrator.getStatus());
            alo.setCreateTimes(administrator.getCreateTime().getTime());
            return alo;
        }).collect(Collectors.toList());

        PageOutDTO<AdministratorListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setList(list);
        return pageOutDTO;
    }

    /* *
     * 信息展示
     * @param administratorId
     * @return
     */
    @GetMapping("/getById")
    public AdministratorShowOutDTO getById(@RequestParam Integer administratorId){
        Administrator administrator = administratorService.getById(administratorId);
        AdministratorShowOutDTO administratorShowOutDTO = new AdministratorShowOutDTO();
        administratorShowOutDTO.setAdministratorId(administrator.getAdministratorId());
        administratorShowOutDTO.setUsername(administrator.getUsername());
        administratorShowOutDTO.setRealName(administrator.getRealName());
        administratorShowOutDTO.setEmail(administrator.getEmail());
        administratorShowOutDTO.setAvatarUrl(administrator.getAvatarUrl());
        administratorShowOutDTO.setStatus(administrator.getStatus());
        return administratorShowOutDTO;
    }

    /* *
     * 创建信息
     * @param administratorCreateInDTO
     * @return
     */
    @PostMapping("/create")
    public Integer create(@RequestBody AdministratorCreateInDTO administratorCreateInDTO){
        Administrator administrator = new Administrator();
        administrator.setUsername(administratorCreateInDTO.getUsername());
        administrator.setRealName(administratorCreateInDTO.getRealName());
        administrator.setEmail(administratorCreateInDTO.getEmail());
        administrator.setAvatarUrl(administratorCreateInDTO.getAvatarUrl());
        administrator.setStatus((byte) AdministratorStatus.Enable.ordinal());
        administrator.setCreateTime(new Date());

        String pwd = BCrypt.withDefaults().hashToString(12, administratorCreateInDTO.getPassword().toCharArray());
        administrator.setEncryptedPassword(pwd);

        // 调用接口
        Integer administratorId = administratorService.create(administrator);
        return administratorId;
    }

    /* *
     * 更新信息
     */
    @PostMapping("/update")
    public void update(@RequestBody AdministratorUpdateInDTO administratorUpdateInDTO){
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(administratorUpdateInDTO.getAdministratorId());
        administrator.setRealName(administratorUpdateInDTO.getRealName());
        administrator.setEmail(administratorUpdateInDTO.getEmail());
        administrator.setAvatarUrl(administratorUpdateInDTO.getAvatarUrl());
        administrator.setStatus(administratorUpdateInDTO.getStatus());
        String password = administratorUpdateInDTO.getPassword();

        if (password != null && !password.isEmpty()){
            String pwd = BCrypt.withDefaults().hashToString(12, password.toCharArray());
            administrator.setEncryptedPassword(pwd);
        }
        administratorService.update(administrator);
    }

    /* *
     * 单挑信息删除
     * @param administratorId
     */
    @PostMapping("/delete")
    public void delete(@RequestBody Integer administratorId){
        administratorService.delete(administratorId);
    }

    /* *
     * 批量删除信息
     * @param administratorIds
     */
    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> administratorIds){
        administratorService.batchDelete(administratorIds);
    }
}
