package com.blog.service.user.impl;

import com.blog.bean.user.User;
import com.blog.service.base.DaoSupport;
import com.blog.service.user.UserService;
import com.blog.utils.MD5;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-1-27
 * Time: 下午3:03
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceBean extends DaoSupport<User> implements UserService{
    public boolean validate(String username,String password){
        long count=(Long)em.createQuery("select count(o) from User o where o.username=?1 and o.password=?2")
                .setParameter(1,username).setParameter(2, MD5.MD5Encode(password)).getSingleResult();
        return count>0;
    }
}
