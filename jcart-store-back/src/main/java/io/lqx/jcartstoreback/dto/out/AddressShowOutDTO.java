package io.lqx.jcartstoreback.dto.out;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/6 15:04
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class AddressShowOutDTO {
    private Integer addressId;
    private String tag;
    private String receiverName;
    private String receiverMobile;
    private String content;
}
