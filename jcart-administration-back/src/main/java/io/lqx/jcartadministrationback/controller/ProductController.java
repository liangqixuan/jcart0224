package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.lqx.jcartadministrationback.dto.in.ProductSearchInDTO;
import io.lqx.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.lqx.jcartadministrationback.dto.out.PageOutDTO;
import io.lqx.jcartadministrationback.dto.out.ProductListOutDTO;
import io.lqx.jcartadministrationback.dto.out.ProductShowOutDTO;
import org.springframework.web.bind.annotation.*;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 14:02
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    /* *
     * 商品搜索
     * @param productSearchInDTO
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(@RequestBody ProductSearchInDTO productSearchInDTO,
                                                @RequestParam Integer pageNum){
        return null;
    }

    /* *
     * 添加商品
     * @param productCreateInDTO
     * @return
     */
    @PostMapping("/create")
    public String create(@RequestBody ProductCreateInDTO productCreateInDTO){
        return null;
    }

    /* *
     * 更新商品
     * @param productUpdateInDTO
     * @return
     */
    @PostMapping("/update")
    public String update(@RequestBody ProductUpdateInDTO productUpdateInDTO){
        return null;
    }

    /* *
     * 商品详情
     * @param productId
     * @return
     */
    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        return null;
    }
}
