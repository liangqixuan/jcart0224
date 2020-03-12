package io.lqx.jcartadministrationback.dto.in;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 14:57
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class OrderSearchInDTO {
    private Long orderId;
    private String customerName;
    private Byte status;
    private Double totalPrice;
    private Long startTimestamp;
    private Long endTimestamp;
}
