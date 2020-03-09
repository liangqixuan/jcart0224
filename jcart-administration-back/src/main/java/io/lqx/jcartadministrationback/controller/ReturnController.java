package io.lqx.jcartadministrationback.controller;

import com.github.pagehelper.Page;
import io.lqx.jcartadministrationback.dto.in.ReturnSearchInDTO;
import io.lqx.jcartadministrationback.dto.in.ReturnUpdateActionInDTO;
import io.lqx.jcartadministrationback.dto.out.PageOutDTO;
import io.lqx.jcartadministrationback.dto.out.ReturnListOutDTO;
import io.lqx.jcartadministrationback.dto.out.ReturnShowOutDTO;
import io.lqx.jcartadministrationback.po.Return;
import io.lqx.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 15:49
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    /* *
     * 退单申请信息
     * @param returnSearchInDTO
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<ReturnListOutDTO> search(ReturnSearchInDTO returnSearchInDTO,
                                               @RequestParam(required = false, defaultValue = "1") Integer pageNum){
        // 根据分页条件进行查询
        Page<Return> page = returnService.search(returnSearchInDTO, pageNum);
        List<ReturnListOutDTO> list = page.stream().map(aReturn -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setReturnId(aReturn.getReturnId());
            returnListOutDTO.setOrderId(aReturn.getOrderId());
            returnListOutDTO.setCustomerId(aReturn.getCustomerId());
            returnListOutDTO.setCustomerName(aReturn.getCustomerName());
            returnListOutDTO.setProductCode(aReturn.getProductCode());
            returnListOutDTO.setProductName(aReturn.getProductName());
            returnListOutDTO.setStatus(aReturn.getStatus());
            returnListOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
            returnListOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());
            return returnListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<ReturnListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(list);
        return pageOutDTO;
    }

    /* *
     * 退单详情
     * @param returnId
     * @return
     */
    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        // 根据id查询单条信息
        Return aReturn = returnService.getById(returnId);

        ReturnShowOutDTO returnShowOutDTO = new ReturnShowOutDTO();
        returnShowOutDTO.setReturnId(aReturn.getReturnId());
        returnShowOutDTO.setOrderId(aReturn.getOrderId());
        returnShowOutDTO.setOrderTimestamp(aReturn.getOrderTime().getTime());
        returnShowOutDTO.setCustomerId(aReturn.getCustomerId());
        returnShowOutDTO.setCustomerName(aReturn.getCustomerName());
        returnShowOutDTO.setMobile(aReturn.getMobile());
        returnShowOutDTO.setEmail(aReturn.getEmail());
        returnShowOutDTO.setStatus(aReturn.getStatus());
        returnShowOutDTO.setAction(aReturn.getAction());
        returnShowOutDTO.setProductCode(aReturn.getProductCode());
        returnShowOutDTO.setProductName(aReturn.getProductName());
        returnShowOutDTO.setQuantity(aReturn.getQuantity());
        returnShowOutDTO.setReason(aReturn.getReason());
        returnShowOutDTO.setOpened(aReturn.getOpened());
        returnShowOutDTO.setComment(aReturn.getComment());
        returnShowOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
        returnShowOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());
        return returnShowOutDTO;
    }

    /* *
     * 更新信息
     * @param returnUpdateActionInDTO
     */
    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO){
        // 创建一个空对象
        Return aReturn = new Return();
        aReturn.setReturnId(returnUpdateActionInDTO.getReturnId());
        aReturn.setAction(returnUpdateActionInDTO.getAction());
        aReturn.setUpdateTime(new Date());
        returnService.update(aReturn);
    }
}
