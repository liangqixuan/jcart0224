package io.lqx.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.lqx.jcartadministrationback.dao.AdministratorMapper;
import io.lqx.jcartadministrationback.po.Administrator;
import io.lqx.jcartadministrationback.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/2 13:28
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator getById(Integer administratorId) {
        Administrator administrator = administratorMapper.selectByPrimaryKey(administratorId);
        return administrator;
    }

    @Override
    public Administrator getByUsername(String username) {
        Administrator administrator = administratorMapper.selectByUsername(username);
        return administrator;
    }

    @Override
    public Integer create(Administrator administrator) {
        administratorMapper.insertSelective(administrator);
        Integer administratorId = administrator.getAdministratorId();
        return administratorId;
    }

    @Override
    public void update(Administrator administrator) {
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

    @Override
    public void delete(Integer administratorId) {
        administratorMapper.deleteByPrimaryKey(administratorId);
    }

    @Override
    public void batchDelete(List<Integer> administratorIds) {
        administratorMapper.batchDelete(administratorIds);
    }

    @Override
    public Page<Administrator> getList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Administrator> page = administratorMapper.selectList();
        return page;
    }

    @Override
    public Administrator getByEmail(String email) {
        Administrator administrator = administratorMapper.selectByEmail(email);
        return administrator;
    }
}
