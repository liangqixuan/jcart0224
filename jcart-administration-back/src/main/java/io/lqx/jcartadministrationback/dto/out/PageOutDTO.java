package io.lqx.jcartadministrationback.dto.out;

import lombok.Data;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 13:43
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class PageOutDTO<T> {
    private Integer total;
    private Integer pageSize;
    private Integer pageNum;
    private List<T> list;

}
