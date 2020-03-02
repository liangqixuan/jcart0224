package io.lqx.jcartstoreback.service.impl;

import io.lqx.jcartstoreback.po.Address;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/2 9:49
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface AddressService {

    List<Address> getByCustomerId(Integer customerId);

    Integer create(Address address);

    void update(Address address);

    void delete(Integer addressId);

}
