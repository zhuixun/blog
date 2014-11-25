package com.blog.web.formbean.article;

import com.blog.web.formbean.BaseForm;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-3-3
 * Time: 下午1:20
 * To change this template use File | Settings | File Templates.
 */
public class ArticleForm extends BaseForm {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3839624654288593802L;
	/** ID **/
    private Integer articleid;
    /** 文章标题 **/
    private String name;
    /** 文章类型 **/
    private Integer typeid;
    /** 分类名称 **/
    private String category;
    /** 文章描述 **/
    private String description;
    /** 文章url地址 **/
	private String url;
	/** 文章关键词 **/
	private String keyword;
    /** 文章点击数 **/
    private Integer clickcount;

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
    
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getClickcount() {
		return clickcount;
	}
	public void setClickcount(Integer clickcount) {
		this.clickcount = clickcount;
	}
}
