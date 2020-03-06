package io.lqx.jcartadministrationback.dto.out;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 14:32
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class CustomerShowOutDTO {
    private Integer customerId;
    private String username;
    private String realName;
    private String avatarUrl;
    private String mobile;
    private String email;
    private Byte status;
    private Long createTimestamp;
    private Boolean newsSubscribed;
    private Integer rewordPoints;
    private Integer defaultAddressId;
    private String defaultAddress;
}
