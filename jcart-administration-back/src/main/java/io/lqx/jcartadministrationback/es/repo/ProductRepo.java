package io.lqx.jcartadministrationback.es.repo;

import io.lqx.jcartadministrationback.es.doc.ProductDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/24 20:23
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface ProductRepo extends ElasticsearchRepository<ProductDoc,Integer> {
}
