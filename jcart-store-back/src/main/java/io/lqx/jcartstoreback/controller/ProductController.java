package io.lqx.jcartstoreback.controller;

import com.github.pagehelper.Page;
import io.lqx.jcartstoreback.dto.in.ProductSearchInDTO;
import io.lqx.jcartstoreback.dto.out.PageOutDTO;
import io.lqx.jcartstoreback.dto.out.ProductListOutDTO;
import io.lqx.jcartstoreback.dto.out.ProductShowOutDTO;
import io.lqx.jcartstoreback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 18:05
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
     * 查询列表数据
     * @param productSearchInDTO
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<ProductListOutDTO> page = productService.search(pageNum);
        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);
        return pageOutDTO;
    }

    /* *
     * 根据id查询单条数据信息
     * @param productId
     * @return
     */
    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getShowById(productId);
        return productShowOutDTO;
    }

}