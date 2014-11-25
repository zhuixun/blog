package com.blog.service.user;

import com.blog.bean.user.User;
import com.blog.service.base.DAO;

/**
 * 用户业务处理类
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-1-26
 * Time: 下午2:59
 * To change this template use File | Settings | File Templates.
 */
public interface UserService extends DAO<User> {
    /**
     * 校验用户名密码是否正确
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public boolean validate(String username,String password);

}
