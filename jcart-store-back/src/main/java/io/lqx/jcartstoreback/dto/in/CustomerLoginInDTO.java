package io.lqx.jcartstoreback.dto.in;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 17:01
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class CustomerLoginInDTO {
    private String username;
    private String password;
}
