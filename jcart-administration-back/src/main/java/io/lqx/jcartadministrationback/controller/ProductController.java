package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.lqx.jcartadministrationback.dto.in.ProductSearchInDTO;
import io.lqx.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.lqx.jcartadministrationback.dto.out.PageOutDTO;
import io.lqx.jcartadministrationback.dto.out.ProductListOutDTO;
import io.lqx.jcartadministrationback.dto.out.ProductShowOutDTO;
import io.lqx.jcartadministrationback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 14:02
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

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
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        Integer productId = productService.create(productCreateInDTO);
        return productId;
    }

    /* *
     * 更新商品
     * @param productUpdateInDTO
     * @return
     */
    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){
        productService.update(productUpdateInDTO);
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

    /* *
     * 一条数据删除
     * @param productId
     */
    @PostMapping("/delete")
    public void delete(@RequestBody Integer productId){
        productService.delete(productId);
    }

    /* *
     * 多条数据删除
     * @param productIds
     */
    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> productIds){
        productService.batchDelete(productIds);
    }
}
