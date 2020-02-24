package io.lqx.jcartadministrationback.dto.in;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/24 17:34
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class AdministratorUpdateProfileInDTO {
    private String realName;
    private String eamil;
    private String avatarUrl;
    private String password;
    private Byte status;
}
