package io.lqx.jcartadministrationback.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/10 19:11
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Configuration
public class BeanConfig {

    @Bean
    public SecureRandom secureRandom(){
        return new SecureRandom();
    }
}
