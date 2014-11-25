package com.blog.web.formbean.about;

import com.blog.web.formbean.BaseForm;

public class AboutForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8192558453087918732L;
	/** Id **/
	private Integer id;
	/** 内容 **/
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
