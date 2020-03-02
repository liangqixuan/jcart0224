package io.lqx.jcartstoreback.service;

import io.lqx.jcartstoreback.dto.in.CustomerRegisterInDTO;
import io.lqx.jcartstoreback.po.Customer;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/2 9:49
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface CustomerService {

    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    void update(Customer customer);
}
