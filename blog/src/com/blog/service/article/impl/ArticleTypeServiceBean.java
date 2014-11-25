package com.blog.service.article.impl;

import java.util.List;

import javax.persistence.Query;

import com.blog.bean.article.ArticleType;
import com.blog.service.article.ArticleTypeService;
import com.blog.service.base.DaoSupport;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-2-26
 * Time: 下午3:45
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ArticleTypeServiceBean extends DaoSupport<ArticleType> implements ArticleTypeService {

	@SuppressWarnings("unchecked")
	public List<ArticleType> getAllClassify() {
		Query query=em.createQuery("select o from ArticleType o where o.visible=1");
		return query.getResultList();
	}

	public void addTypeCount(Integer typeid) {
		Query query=em.createQuery("update  ArticleType o set o.count=o.count+1  where o.typeid=?1").setParameter(1, typeid);
		query.executeUpdate();
	}
}