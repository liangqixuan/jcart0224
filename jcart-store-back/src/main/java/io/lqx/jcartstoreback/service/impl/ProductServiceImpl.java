package io.lqx.jcartstoreback.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.lqx.jcartstoreback.dao.ProductDetailMapper;
import io.lqx.jcartstoreback.dao.ProductMapper;
import io.lqx.jcartstoreback.dto.out.ProductListOutDTO;
import io.lqx.jcartstoreback.dto.out.ProductShowOutDTO;
import io.lqx.jcartstoreback.po.Product;
import io.lqx.jcartstoreback.po.ProductDetail;
import io.lqx.jcartstoreback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/2 9:17
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public ProductShowOutDTO getById(Integer productId) {
        // 根据productId查询数据信息
        Product product = productMapper.selectByPrimaryKey(productId);
        ProductDetail productDetail = productDetailMapper.selectByPrimaryKey(productId);

        // 然后进行回显赋值
        ProductShowOutDTO productShowOutDTO = new ProductShowOutDTO();
        productShowOutDTO.setProductId(product.getProductId());
        productShowOutDTO.setProductCode(product.getProductCode());
        productShowOutDTO.setProductName(product.getProductName());
        productShowOutDTO.setPrice(product.getPrice());
        productShowOutDTO.setDiscount(product.getDiscount());
        productShowOutDTO.setMainPicUrl(product.getMainPicUrl());
        productShowOutDTO.setRewordPoints(product.getRewordPoints());
        productShowOutDTO.setStockQuantity(product.getStockQuantity());

        productShowOutDTO.setDescription(productDetail.getDescription());
        String otherPicUrlsJson = productDetail.getOtherPicUrls();
        List<String> otherPicUrls = JSON.parseArray(otherPicUrlsJson, String.class);
        productShowOutDTO.setOtherPicUrls(otherPicUrls);
        return productShowOutDTO;
    }

    @Override
    public Page<ProductListOutDTO> search(Integer pageNum) {
        // 开启分页插件
        PageHelper.startPage(pageNum, 10);
        Page<ProductListOutDTO> page = productMapper.search();
        return page;
    }
}
