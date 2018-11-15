package com.sys.gateway.dao;

import java.util.List;

/**
 * 数据库操作公共接口，包含增删改查功能
 *
 * 1、所有的基础对象操作需要继承该接口
 * 2、所有的Mapper文件需求实现该接口
 *
 * Create By LD   2018-09-25
 * */
public interface SqlMapper<T> {

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return T 返回实体类
     *
     * @Auth Create By LD   2018-09-25
     * */
    T selectByPrimaryKey(String id);

    /**
     * 通过主键查询
     *
     * @param vo 自定义查询条件
     * @return List<T> 返回实体类List
     *
     * @Auth Create By LD   2018-09-25
     * */
    List<T> queryByCondition(T vo);

    /**
     * 通过主键删除
     *
     * @param id 主键
     *
     * @Auth Create By LD   2018-09-25
     * */
    int deleteByPrimaryKey(String id);

    /**
     * 插入数据（所有字段）
     *
     * @param recode 插入的实体
     *
     * @Auth Create By LD   2018-09-25
     * */
    int insert(T recode);

    /**
     * 自定义插入
     *
     * @param recode 插入的数据实体
     *
     * @Auth Create By LD   2018-09-25
     * */
    int insertSelective(T recode);

    /**
     * 通过主键更新其他所有数据
     *
     * @param recode 更新的数据实体
     *
     * @Auth Create By LD   2018-09-25
     * */
    int updateByPrimaryKey(T recode);

    /**
     * 通过主键更新自定义数据，只更新不为空的数据
     *
     * @param recode 更新数据实体
     *
     * @Auth Create By LD   2018-09-25
     * */
    int updateByPrimaryKeySelective(T recode);
}
