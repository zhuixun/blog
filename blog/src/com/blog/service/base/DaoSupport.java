package com.blog.service.base;

import com.blog.bean.QueryResult;
import com.blog.utils.GenericsUtils;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-2-11
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public abstract class DaoSupport<T> implements DAO<T> {
    @PersistenceContext protected EntityManager em; //代理对象
    /* 实体类 */
    @SuppressWarnings("unchecked")
	protected Class<T> entityClass= GenericsUtils.getSuperClassGenricType(getClass());

    public QueryResult<T> getScrollData(){
        return getScrollData(-1,-1,null,null,null);
    }

    public QueryResult<T> getScrollData(int firstResult,int maxResult){
        return getScrollData(firstResult,maxResult,null,null,null);
    }

    public QueryResult<T> getScrollData(int firstResult,int maxResult,LinkedHashMap<String,String> orderby){
        return getScrollData(firstResult,maxResult,null,null,orderby);
    }

    public QueryResult<T> getScrollData(int firstResult,int maxResult,String where,Object[] params){
        return getScrollData(firstResult,maxResult,where,params,null);
    }
    public QueryResult<T> getScrollData(int firstResult,int maxResult,String where,Object[] params,LinkedHashMap<String,String> orderby){
        String entityName=getEntityName(entityClass);
        String whereql=where!=null && !"".equals(where.trim()) ? " where "+ where :"";//where o.username?=1 and o.email like 3
        Query query=em.createQuery("select o from "+ entityName +" o"+ whereql +buildOrderby(orderby));
        if(firstResult!=-1&&maxResult!=-1)query.setFirstResult(firstResult).setMaxResults(maxResult);// limit 0,10
        setQueryParameter(query,params);
        QueryResult<T> qr=new QueryResult<T>();
        qr.setResultlist(query.getResultList());
        query=em.createQuery("select count(o) from "+ entityName +" o"+ whereql);
        setQueryParameter(query,params);
        qr.setTotalrecord((Long)query.getSingleResult());
        return qr;
    }

    /**
     * 设置查询参数
     * @param query
     * @param params
     */
    public static void setQueryParameter(Query query,Object[] params){
        if(params!=null){
            for(int i=0;i<params.length;i++){
                query.setParameter(i+1,params[i]);
            }
        }
    }

    /**
     * 构建排序语句
     * @param orderby 排序属性order by xxx desc,aaa asc
     * @return
     */
    public static String buildOrderby(LinkedHashMap<String,String> orderby){
        StringBuilder sb=new StringBuilder();
        if (orderby!=null && !orderby.isEmpty()){
            sb.append(" order by ");
            for(Map.Entry<String,String> entry :orderby.entrySet()){
                sb.append("o.").append(entry.getKey()).append(" ").append(entry.getValue()).append(",");
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return  sb.toString();
    }
    public String getSubClass(){
        return getClass().getName();
    }

    public void save(T entity) {
        em.persist(entity);
    }

    public void update(T entity) {
        em.merge(entity);
    }

    public void delete(Serializable entityid) {
        em.remove(em.getReference(entityClass ,entityid));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public T find(Serializable entityid) {
        return em.find(entityClass ,entityid);
    }

    public long getCount() {
        return (Long)em.createQuery("select count(o) from "+ getEntityName(this.entityClass) +" o" ).getSingleResult();
    }

    /**
     * 获取实体名称
     * @return entityName
     */
    protected static <E> String getEntityName(Class<E> entityClass){
        String entityName=entityClass.getSimpleName();
        Entity entity=entityClass.getAnnotation(Entity.class);
        if(entity.name()!=null&&!"".equals(entity.name()))entityName=entity.name();
        return entityName;
    }
}
