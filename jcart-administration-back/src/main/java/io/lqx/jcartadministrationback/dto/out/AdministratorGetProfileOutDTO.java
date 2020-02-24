package io.lqx.jcartadministrationback.dto.out;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/24 17:27
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class AdministratorGetProfileOutDTO {
    private Integer adminstratorId;
    private String username;
    private String realName;
    private String email;
    private String avatarUrl;
    private Byte status;
    private Long createTimestamp;
}
