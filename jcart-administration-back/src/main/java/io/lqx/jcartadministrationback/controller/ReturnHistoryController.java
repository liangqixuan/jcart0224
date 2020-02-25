package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.in.ReturnHistoryCreateInDTO;
import io.lqx.jcartadministrationback.dto.out.ReturnHistoryListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 16:32
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/returnhistory")
public class ReturnHistoryController {

    /* *
     * 查询退回历史信息
     * @param returnId
     * @return
     */
    @GetMapping("/getListByReturnId")
    public List<ReturnHistoryListOutDTO> getListByReturnId(@RequestParam Integer returnId){
        return null;
    }

    /* *
     * 创建历史信息
     * @param returnHistoryCreateInDTO
     * @return
     */
    @PostMapping("/create")
    public Integer create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        return null;
    }
}
