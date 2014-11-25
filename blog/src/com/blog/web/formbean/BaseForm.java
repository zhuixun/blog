package com.blog.web.formbean;

import org.apache.struts.action.ActionForm;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-3-3
 * Time: 下午1:22
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("serial")
public class BaseForm extends ActionForm {
    /** 获取当前页 **/
    private int page;

    public int getPage() {
        return page<1? 1 : page;
    }
    public void setPage(int page) {


        this.page = page;
    }
}
