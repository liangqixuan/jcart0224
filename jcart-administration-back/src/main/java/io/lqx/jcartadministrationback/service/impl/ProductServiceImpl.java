package io.lqx.jcartadministrationback.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import io.lqx.jcartadministrationback.dao.ProductDetailMapper;
import io.lqx.jcartadministrationback.dao.ProductMapper;
import io.lqx.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.lqx.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.lqx.jcartadministrationback.dto.out.ProductListOutDTO;
import io.lqx.jcartadministrationback.dto.out.ProductShowOutDTO;
import io.lqx.jcartadministrationback.po.Product;
import io.lqx.jcartadministrationback.po.ProductDetail;
import io.lqx.jcartadministrationback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/26 16:13
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
    @Transactional
    public Integer create(ProductCreateInDTO productCreateInDTO) {

        // 创建商品对象
        Product product = new Product();
        // 进行赋值
        product.setProductCode(productCreateInDTO.getProductCode());
        product.setProductName(productCreateInDTO.getProductName());
        product.setPrice(productCreateInDTO.getPrice());
        product.setDiscount(productCreateInDTO.getDiscount());
        product.setStockQuantity(productCreateInDTO.getStockQuantity());
        product.setStatus(productCreateInDTO.getStatus());
        product.setMainPicUrl(productCreateInDTO.getMainPicUrl());
        product.setRewordPoints(productCreateInDTO.getRewordPoints());
        product.setSortOrder(productCreateInDTO.getSortOrder());

        // 获取摘要
        String description = productCreateInDTO.getDescription();
        // 摘要截取
        String productAbstract = description.substring(0, Math.min(100, description.length()));
        product.setProductAbstract(productAbstract);

        // 添加商品数据
        productMapper.insertSelective(product);

        Integer productId = product.getProductId();

        // 创建商品附表
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productId);
        productDetail.setDescription(productCreateInDTO.getDescription());
        List<String> otherPicUrls = productCreateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));

        // 添加商品附表数据
        productDetailMapper.insertSelective(productDetail);
        return productId;
    }

    @Override
    @Transactional
    public void update(ProductUpdateInDTO productUpdateInDTO) {

        // 创建商品对象
        Product product = new Product();
        // 进行赋值
        product.setProductId(productUpdateInDTO.getProductId());
        product.setProductName(productUpdateInDTO.getProductName());
        product.setPrice(productUpdateInDTO.getPrice());
        product.setDiscount(productUpdateInDTO.getDiscount());
        product.setStockQuantity(productUpdateInDTO.getStockQuantity());
        product.setMainPicUrl(productUpdateInDTO.getMainPicUrl());
        product.setStatus(productUpdateInDTO.getStatus());
        product.setRewordPoints(productUpdateInDTO.getRewordPoints());
        product.setSortOrder(productUpdateInDTO.getSortOrder());
        String description = productUpdateInDTO.getDescription();
        String productAbstract = description.substring(0, Math.min(100, description.length()));
        product.setProductAbstract(productAbstract);
        // 更新商品数据
        productMapper.updateByPrimaryKeySelective(product);

        // 创建商品附表
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productUpdateInDTO.getProductId());
        productDetail.setDescription(productUpdateInDTO.getDescription());
        List<String> otherPicUrls = productUpdateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));
        // 更新商品附表数据
        productDetailMapper.updateByPrimaryKeySelective(productDetail);

    }

    @Override
    public void delete(Integer productId) {

    }

    @Override
    public void batchDelete(List<Integer> productIds) {

    }

    @Override
    public Page<ProductListOutDTO> search(Integer pageNum) {
        return null;
    }

    @Override
    public ProductShowOutDTO getById(Integer productId) {
        return null;
    }
}
