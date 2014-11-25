package com.blog.bean.webset;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SetSettings implements Serializable {

	/**
	 * 网站关键词、描述、热门标签设置
	 */
	private static final long serialVersionUID = -364319666543600296L;
	
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
	
	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 50)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(length=50)
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Column(length=100)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(length=50)
	public String getHotTitle() {
		return hotTitle;
	}
	public void setHotTitle(String hotTitle) {
		this.hotTitle = hotTitle;
	}
	@Column(length=200)
	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SetSettings other = (SetSettings) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 
	
}
