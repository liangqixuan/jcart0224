package io.lqx.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.lqx.jcartadministrationback.po.Administrator;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/2 13:20
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public interface AdministratorService {

    Administrator getById(Integer administratorId);

    Administrator getByUsername(String username);

    Integer create(Administrator administrator);

    void update(Administrator administrator);

    void delete(Integer administratorId);

    void batchDelete(List<Integer> administratorIds);

    Page<Administrator> getList(Integer pageNum);
}
