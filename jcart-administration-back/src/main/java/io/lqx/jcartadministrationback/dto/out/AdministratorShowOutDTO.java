package io.lqx.jcartadministrationback.dto.out;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 13:50
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class AdministratorShowOutDTO {
    private Integer administratorId;
    private String username;
    private String realName;
    private String email;
    private String avatarUrl;
    private Byte status;
}
