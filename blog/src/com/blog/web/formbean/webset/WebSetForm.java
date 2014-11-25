package com.blog.web.formbean.webset;

import org.apache.struts.action.ActionForm;

public class WebSetForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -572979986802353991L;
	private Integer id;
	/** 网站标题 **/
	private String title;
	/** 网站关键词 **/
	private String keyword;     
	/** 网站描述 **/
	private String description;
	/** 热门标签 **/
	private String hotTitle; 
	/** 网站底部 **/
	private String footer;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHotTitle() {
		return hotTitle;
	}
	public void setHotTitle(String hotTitle) {
		this.hotTitle = hotTitle;
	}
	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
}
