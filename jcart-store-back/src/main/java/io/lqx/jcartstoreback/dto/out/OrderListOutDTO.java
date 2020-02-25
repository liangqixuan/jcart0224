package io.lqx.jcartstoreback.dto.out;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 17:08
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class OrderListOutDTO {
    private Long orderId;
    private Integer customerId;
    private String customerName;
    private Integer totalProducts;
    private Byte status;
    private Double totalPrice;
    private Long createTimestamp;
}
