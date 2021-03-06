package io.lqx.jcartstoreback.dto.in;

import lombok.Data;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 17:02
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class OrderCheckoutInDTO {
    private Short shipMethod;
    private Integer shipAddressId;
    private Short payMethod;
    private Integer invoiceAddressId;
    private String comment;
    private List<OrderProductInDTO> orderProducts;
}
