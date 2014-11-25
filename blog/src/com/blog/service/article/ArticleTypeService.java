package com.blog.service.article;

import java.util.List;

import com.blog.bean.article.ArticleType;
import com.blog.service.base.DAO;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-2-26
 * Time: 下午3:41
 * To change this template use File | Settings | File Templates.
 */
public interface ArticleTypeService extends DAO<ArticleType> {
	
	//获得所有分类
	public List<ArticleType> getAllClassify();
	//添加文章给分类数+1
	public void addTypeCount(Integer typeid);
}
