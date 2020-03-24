package io.lqx.jcartadministrationback.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.lqx.jcartadministrationback.dao.ProductDetailMapper;
import io.lqx.jcartadministrationback.dao.ProductMapper;
import io.lqx.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.lqx.jcartadministrationback.dto.in.ProductSearchInDTO;
import io.lqx.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.lqx.jcartadministrationback.dto.out.ProductListOutDTO;
import io.lqx.jcartadministrationback.dto.out.ProductShowOutDTO;
import io.lqx.jcartadministrationback.es.doc.ProductDoc;
import io.lqx.jcartadministrationback.es.repo.ProductRepo;
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

    @Autowired
    private ProductRepo productRepo;// 继承esRepository
    
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
        product.setProductAbstract(productCreateInDTO.getProductAbstract());

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

        ProductDoc pdc = new ProductDoc();
        pdc.setProductId(productId);
        pdc.setProductName(productCreateInDTO.getProductName());
        pdc.setProductCode(productCreateInDTO.getProductCode());
        pdc.setProductAbstract(productCreateInDTO.getProductAbstract());
        ProductDoc save = productRepo.save(pdc);

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
        product.setProductAbstract(productUpdateInDTO.getProductAbstract());
        productMapper.updateByPrimaryKeySelective(product);
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
    @Transactional
    public void delete(Integer productId) {
        // 删除商品表数据
        productMapper.deleteByPrimaryKey(productId);
        // 删除商品附表数据
        productDetailMapper.deleteByPrimaryKey(productId);
    }

    @Override
    @Transactional
    public void batchDelete(List<Integer> productIds) {
        // 多条商品数据删除
        productMapper.batchDelete(productIds);
        // 多条商品附表数据删除
        productDetailMapper.batchDelete(productIds);
    }

    @Override
    public Page<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                          Integer pageNum) {
        // 分页插件设置查询条数
        PageHelper.startPage(pageNum,10);
        Page<ProductListOutDTO> page = productMapper.search(
                productSearchInDTO.getProductCode(),
                productSearchInDTO.getStatus(),
                productSearchInDTO.getStockQuantity(),
                productSearchInDTO.getPrice(),
                productSearchInDTO.getProductName());
        return page;
    }

    @Override
    public ProductShowOutDTO getById(Integer productId) {
        // 根据商品Id查询单条商品数据信息
        Product product = productMapper.selectByPrimaryKey(productId);
        // 根据商品Id查询单条商品附表数据信息
        ProductDetail productDetail = productDetailMapper.selectByPrimaryKey(productId);

        // 创建显示信息对象
        ProductShowOutDTO productShowOutDTO = new ProductShowOutDTO();
        // 查询的数据进行赋值
        productShowOutDTO.setProductCode(product.getProductCode());
        productShowOutDTO.setProductName(product.getProductName());
        productShowOutDTO.setPrice(product.getPrice());
        productShowOutDTO.setDiscount(product.getDiscount());
        productShowOutDTO.setStatus(product.getStatus());
        productShowOutDTO.setMainPicUrl(product.getMainPicUrl());
        productShowOutDTO.setRewordPoints(product.getRewordPoints());
        productShowOutDTO.setSortOrder(product.getSortOrder());
        productShowOutDTO.setStockQuantity(product.getStockQuantity());
        productShowOutDTO.setProductAbstract(product.getProductAbstract());

        productShowOutDTO.setDescription(productDetail.getDescription());
        String otherPicUrlsJson = productDetail.getOtherPicUrls();
        List<String> otherPicUrls = JSON.parseArray(otherPicUrlsJson, String.class);
        productShowOutDTO.setOtherPicUrls(otherPicUrls);

        return productShowOutDTO;
    }
}
