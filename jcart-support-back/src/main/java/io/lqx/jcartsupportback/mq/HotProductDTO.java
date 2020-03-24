package io.lqx.jcartsupportback.mq;

import lombok.Data;

import java.io.Serializable;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/23 20:31
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class HotProductDTO implements Serializable {

    private Integer productId;
    private String productCode;
}
