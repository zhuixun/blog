package com.blog.web.formbean.article;

import com.blog.web.formbean.BaseForm;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-2-26
 * Time: 下午3:27
 * To change this template use File | Settings | File Templates.
 */
public class ArticleTypeForm extends BaseForm {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4755237344827955829L;
	private Integer parentid;
    private String name;
    private String note;
    private Integer typeid;

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
}
