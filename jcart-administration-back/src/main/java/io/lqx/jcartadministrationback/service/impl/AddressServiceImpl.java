package io.lqx.jcartadministrationback.service.impl;

import io.lqx.jcartadministrationback.dao.AddressMapper;
import io.lqx.jcartadministrationback.po.Address;
import io.lqx.jcartadministrationback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/6 20:59
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Address getById(Integer addressId) {
        Address address = addressMapper.selectByPrimaryKey(addressId);
        return address;
    }

    @Override
    public List<Address> getByCustomerId(Integer customerId) {
        List<Address> addresses = addressMapper.selectByCustomerId(customerId);
        return addresses;
    }
}
