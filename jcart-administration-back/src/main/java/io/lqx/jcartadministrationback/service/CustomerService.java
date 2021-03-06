package io.lqx.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.lqx.jcartadministrationback.dto.in.CustomerSearchInDTO;
import io.lqx.jcartadministrationback.dto.in.CustomerSetStatusInDTO;
import io.lqx.jcartadministrationback.po.Customer;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/6 20:53
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface CustomerService {

    Customer getById(Integer customerId);

    Page<Customer> search(CustomerSearchInDTO customerSearchInDTO,Integer pageNum);

    void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO);
}
