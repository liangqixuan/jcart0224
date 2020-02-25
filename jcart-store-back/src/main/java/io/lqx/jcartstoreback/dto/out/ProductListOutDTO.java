package io.lqx.jcartstoreback.dto.out;

import lombok.Data;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 17:12
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class ProductListOutDTO {
    private Integer productId;
    private String productCode;
    private String productName;
    private String productAbstract;
    private Double price;
    private Double discount;
    private String mainPicUrl;

}
