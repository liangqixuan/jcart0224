package io.lqx.jcartstoreback.dao;

import io.lqx.jcartstoreback.dto.out.ProductListOutDTO;
import io.lqx.jcartstoreback.po.ProductOperation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOperationMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(ProductOperation record);

    int insertSelective(ProductOperation record);

    ProductOperation selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(ProductOperation record);

    int updateByPrimaryKey(ProductOperation record);

    List<ProductOperation> selectHotProduct();
}