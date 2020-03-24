package io.lqx.jcartsupportback.consumer;


import com.alibaba.fastjson.JSON;
import io.lqx.jcartsupportback.mq.HotProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/23 19:51
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Component
public class HotProductConsumer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "test",groupId = "hot-product-group01")
    public void consumerHotProduct(String productStr){
        logger.info("consumer productId: {}",productStr);
        HotProductDTO hotProductDTO = JSON.parseObject(productStr, HotProductDTO.class);
        System.out.println(hotProductDTO);
        /*ProductOperation productOperation = productOperationMapper.selectByPrimaryKey(productId);

        if(productOperation == null){
            ProductOperation pro = new ProductOperation();
            pro.setProductId(productId);
            pro.setAllCount(1);
            pro.setDayCount(1);
            pro.setRecentTime(new Date());
            productOperationMapper.insertSelective(pro);
        }else{
            productOperation.setAllCount(productOperation.getAllCount()+1);
            productOperation.setDayCount(productOperation.getAllCount()+1);
            productOperation.setRecentTime(new Date());
            productOperationMapper.updateByPrimaryKeySelective(productOperation);
        }*/
    }
}
