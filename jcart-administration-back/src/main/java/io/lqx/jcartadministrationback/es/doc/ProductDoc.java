package io.lqx.jcartadministrationback.es.doc;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/24 20:15
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Document(indexName = "productdoc")//es的注解用来指定索引名称
@Data
public class ProductDoc {
    @Id//指定id
    private Integer productId;
    private String productCode;
    private String productName;
    private String productAbstract;
}
