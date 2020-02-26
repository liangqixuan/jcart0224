package io.lqx.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.lqx.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.lqx.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.lqx.jcartadministrationback.dto.out.ProductListOutDTO;
import io.lqx.jcartadministrationback.dto.out.ProductShowOutDTO;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/26 16:00
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface ProductService {

    Integer create(ProductCreateInDTO productCreateInDTO);

    void update(ProductUpdateInDTO productUpdateInDTO);

    void delete(Integer productId);

    void batchDelete(List<Integer> productIds);

    Page<ProductListOutDTO> search(Integer pageNum);

    ProductShowOutDTO getById(Integer productId);

}
