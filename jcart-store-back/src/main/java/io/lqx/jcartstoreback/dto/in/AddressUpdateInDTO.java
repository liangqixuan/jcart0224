package io.lqx.jcartstoreback.dto.in;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 17:00
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class AddressUpdateInDTO {
    private String receiverName;
    private String receiverMobile;
    private String content;
    private String tag;
}
