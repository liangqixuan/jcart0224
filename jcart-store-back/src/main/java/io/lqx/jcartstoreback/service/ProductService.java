package io.lqx.jcartstoreback.service;

import com.github.pagehelper.Page;
import io.lqx.jcartstoreback.dto.out.ProductListOutDTO;
import io.lqx.jcartstoreback.dto.out.ProductShowOutDTO;
import io.lqx.jcartstoreback.po.Product;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/2 9:16
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface ProductService {

    Product getById(Integer productId);

    ProductShowOutDTO getShowById(Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum);
}
