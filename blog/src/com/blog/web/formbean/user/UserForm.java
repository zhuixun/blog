package com.blog.web.formbean.user;

import org.apache.struts.action.ActionForm;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-2-19
 * Time: 下午4:18
 * To change this template use File | Settings | File Templates.
 */
public class UserForm extends ActionForm {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5170292339041878452L;
	private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
