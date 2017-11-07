package com.lanou.mapper;

import com.lanou.domain.User;

import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
 /*该接口与UserMapper.xml文件对应*/
public interface UserDao {
    /**
     *  查询所有
     *  方法名称对应UserMapper.xml中的某个id
     *  返回类型与UserMapper.xml中的resultType对应
     * @return
     */
    List<User> findAll();
}
