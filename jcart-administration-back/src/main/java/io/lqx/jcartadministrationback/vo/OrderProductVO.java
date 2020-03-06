package io.lqx.jcartadministrationback.vo;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/6 20:49
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class OrderProductVO {
    private Integer productId;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private Integer unitRewordPoints;
    private Integer totalRewordPoints;
}
