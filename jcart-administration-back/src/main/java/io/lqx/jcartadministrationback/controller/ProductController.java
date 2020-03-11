package io.lqx.jcartadministrationback.controller;

import com.github.pagehelper.Page;
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
@CrossOrigin
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
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<ProductListOutDTO> page = productService.search(productSearchInDTO,pageNum);

        // 分页存取数据
        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setList(page);
        return pageOutDTO;
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
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);
        return productShowOutDTO;
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
