package io.lqx.jcartadministrationback.mq;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/20 14:49
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class EmailEvent {

    private String toEmail;
    private String title;
    private String content;
}
