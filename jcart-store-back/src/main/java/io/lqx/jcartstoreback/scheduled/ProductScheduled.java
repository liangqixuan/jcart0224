package io.lqx.jcartstoreback.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Set;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/24 11:07
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Component
public class ProductScheduled {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StringRedisTemplate redisTemplate;

    //public static final String allKey = "Hot*";

    @Scheduled(fixedDelay = 30*1000)//作用删除缓存
    public void removeHotProduct(){
        logger.info("remove hot product");
        String key = "HotProducts";
        Boolean delete = redisTemplate.delete(key);
        System.out.println(delete);
        //Set<String> keys = redisTemplate.keys(allKey);
        /*if(keys!=null && keys.size()>0){
            for(String key : keys){
                System.out.println(key);
                Boolean delete = redisTemplate.delete(key);
            }
        }else {
            System.out.println("没有该类型缓存");
        }*/

    }
}
