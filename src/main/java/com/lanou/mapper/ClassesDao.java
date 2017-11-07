package com.lanou.mapper;

import com.lanou.domain.Classes;

import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
public interface ClassesDao {
    /**
     * 添加班级
     * 方法名与映射文件中的id对应
     * 参数名与映射文件中的#好取值对应
     */
     void addClasses(Classes classes);

    /**
     * 查询所有
     * @return
     */
    List<Classes> findAll();

    /**
     * 根据名字查询
     * @param name 班级名字
     * @return
     */
    List<Classes> findByName(String name);

    List<Classes> findByName2(Classes classes);

}
