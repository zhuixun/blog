package com.blog.bean.article;

import org.compass.annotations.Index;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-2-26
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class ArticleType implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8092816603101243775L;
	/** 类别id **/
    private Integer typeid;
    /** 类别目录 **/
    private String category;
    /** 类别名称 **/
    private String name;
    /** 备注，用于google搜索页面描述 **/
    private String note;
    /** 是否可见 **/
    private Boolean visible=true;
    /** 子类别 **/
    private Set<ArticleType> childtypes=new HashSet<ArticleType>();
    /** 所属父类 **/
    private ArticleType parent;
    /** 分类文章数 **/
    private Integer count;

    private Set<ArticleInfo> articles=new HashSet<ArticleInfo>();
    @OneToMany(mappedBy="articletype", cascade=CascadeType.REMOVE)
    public Set<ArticleInfo> getArticles() {
        return articles;
    }
    public void setArticles(Set<ArticleInfo> articles) {
        this.articles = articles;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @SearchableProperty(index= Index.NO,store= Store.YES)
    public Integer getTypeid() {
        return typeid;
    }
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    @Column(length = 36,nullable = false)
    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Column(length = 36,nullable = false) @SearchableProperty(index =Index.NOT_ANALYZED,store = Store.YES,name="typeName")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
	@Column(length = 200)
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    @Column(nullable = false)
    public Boolean getVisible() {
        return visible;
    }
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.REMOVE},mappedBy = "parent")
    public Set<ArticleType> getChildtypes() {
        return childtypes;
    }
    public void setChildtypes(Set<ArticleType> childtypes) {
        this.childtypes = childtypes;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    public ArticleType getParent() {
        return parent;
    }
    public void setParent(ArticleType parent) {
        this.parent = parent;
    }
    
    @Column(nullable = false)
    public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleType that = (ArticleType) o;

        if (typeid != null ? !typeid.equals(that.typeid) : that.typeid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return typeid != null ? typeid.hashCode() : 0;
    }
}
