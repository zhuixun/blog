package com.blog.service.article;

import com.blog.bean.article.ArticleInfo;
import com.blog.service.base.DAO;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-3-2
 * Time: 下午8:40
 * To change this template use File | Settings | File Templates.
 */
public interface ArticleInfoService extends DAO<ArticleInfo> {
	//文章点击量
	public void clickcount(Integer articleid);
	//去除\r\n
	public String htmlToCode(String description);
}
