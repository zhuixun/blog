package com.blog.service.base;

import com.blog.bean.QueryResult;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-2-11
 * Time: 下午3:31
 * To change this template use File | Settings | File Templates.
 */
public interface DAO<T> {
    /**
     * 获取所有记录
     * @return
     */
    public QueryResult<T> getScrollData();

    /**
     * 分页获取记录
     * @param firstResult  开始索引，如果输入值为-1，即获取的全部数据
     * @param maxResult 每页获取的记录数
     * @return
     */
    public QueryResult<T> getScrollData(int firstResult,int maxResult);

    /**
     * 分页获取记录
     * @param firstResult  开始索引，如果输入值为-1，即获取的全部数据
     * @param maxResult 每页获取的记录数
     * @param orderby 排序属性，key为排序属性，value为asc/desc
     * @return
     */
    public QueryResult<T> getScrollData(int firstResult,int maxResult,LinkedHashMap<String,String> orderby);

    /**
     * 分页获取记录
     * @param firstResult  开始索引，如果输入值为-1，即获取的全部数据
     * @param maxResult 每页获取的记录数
     * @param where 条件语句，不带where关键字，条件语句只能使用位置参数，位置参数的索引以1开始，where o.username=?1 and o.password=?2
     * @param params 条件语句出现的位置参数值
     * @return
     */
    public QueryResult<T> getScrollData(int firstResult,int maxResult,String where,Object[] params);

    /**
     * 分页获取记录
     * @param firstResult  开始索引，如果输入值为-1，即获取的全部数据
     * @param maxResult 每页获取的记录数
     * @param where 条件语句，不带where关键字，条件语句只能使用位置参数，位置参数的索引以1开始，where o.username=?1 and o.password=?2
     * @param params 条件语句出现的位置参数值
     * @param orderby 排序属性，key为排序属性，value为asc/desc
     * @return
     */
    public QueryResult<T> getScrollData(int firstResult,int maxResult,String where,Object[] params,LinkedHashMap<String,String> orderby);

    public String getSubClass();

    /**
     * 保持实体
     * @param entity 实体对象
     */
    public void save(T entity);
    /**
     * 更新实体
     * @param entity 实体对象
     */
    public void update(T entity);
    /**
     * 删除实体
     * @param entityid 实体对象的id属性值
     */
    public void delete(Serializable entityid);
    /**
     * 查找实体
     * @param entityid 实体对象的id属性值
     * @return 实体对象
     */
    public T find(Serializable entityid);
    /**
     * 获取实体总记录数
     * @return 总记录数
     */
    public long getCount();
}
