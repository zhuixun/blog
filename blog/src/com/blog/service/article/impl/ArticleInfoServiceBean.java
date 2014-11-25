package com.blog.service.article.impl;

import javax.persistence.Query;

import com.blog.bean.article.ArticleInfo;
import com.blog.service.article.ArticleInfoService;
import com.blog.service.base.DaoSupport;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-3-2
 * Time: 下午8:41
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ArticleInfoServiceBean extends DaoSupport<ArticleInfo> implements ArticleInfoService {

	public void clickcount(Integer articleid) {
		Query query=em.createQuery("update ArticleInfo o set o.clickcount=o.clickcount+1 where o.id=?1").setParameter(1, articleid);
		query.executeUpdate();
	}
	
    public String htmlToCode(String description){
    if(description == null){
    	return "";
    } else{ 	
    	description=description.replace("\r\n", "<br>");//这才是正确的！
    	description=description.replace("\\", "\\\\");//对'\t'不转义
		return description;
    }
    }  
}
