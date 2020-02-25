package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.in.ReturnSearchInDTO;
import io.lqx.jcartadministrationback.dto.in.ReturnUpdateActionInDTO;
import io.lqx.jcartadministrationback.dto.out.PageOutDTO;
import io.lqx.jcartadministrationback.dto.out.ReturnListOutDTO;
import io.lqx.jcartadministrationback.dto.out.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.*;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 15:49
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/return")
public class ReturnController {

    /* *
     * 退单申请信息
     * @param returnSearchInDTO
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<ReturnListOutDTO> search(ReturnSearchInDTO returnSearchInDTO,
                                               @RequestParam Integer pageNum){
        return null;
    }

    /* *
     * 退单详情
     * @param returnId
     * @return
     */
    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    /* *
     * 更新信息
     * @param returnUpdateActionInDTO
     */
    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO){

    }
}
