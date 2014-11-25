package com.blog.bean.article;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-3-2
 * Time: 下午3:19
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class ArticleInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5054535606242678913L;
	/** ID **/
    private Integer id;
    /** 文章标题 **/
    private String name;
    /** 是否可见 **/
    private Boolean visible=true;
    /** 文章类型 **/
    private ArticleType articletype;
    /** 文章描述 **/
    private String description;
    /** 发布时间 **/
    private Date createdate=new Date();
    /** 文章点击数 **/
    private Integer clickcount=1;
    /** 文章url地址 **/
	private String url;
	/** 文章搜索关键字 **/
	private String keyword;
    /** 是否推荐 **/
    private Boolean commend=false;
    /** 文章发布人 **/
    private String editor="小倪";
    
    @Id @GeneratedValue
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 50,nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public Boolean getVisible() {
        return visible;
    }
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @ManyToOne(cascade = CascadeType.REFRESH,optional = false)
    @JoinColumn(name="typeid")
    public ArticleType getArticletype() {
        return articletype;
    }
    public void setArticletype(ArticleType articletype) {
        this.articletype = articletype;
    }

    @Lob @Column(nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.DATE)
    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Column(nullable = false)
    public Integer getClickcount() {
        return clickcount;
    }
    public void setClickcount(Integer clickcount) {
        this.clickcount = clickcount;
    }
    
    @Column(length=50,nullable=false)
    public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(length=50,nullable=false)
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Column(nullable = false)
    public Boolean getCommend() {
        return commend;
    }
    public void setCommend(Boolean commend) {
        this.commend = commend;
    }

    @Column(length=50,nullable=false)
    public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleInfo that = (ArticleInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
