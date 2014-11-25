package com.blog.bean.user;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-2-19
 * Time: 下午2:45
 * To change this template use File | Settings | File Templates.
 */
public enum Gender {
    MAN{public  String getName(){return "男";}
    },
    WOMEN{
        public  String getName(){return "女";}
    };
    public abstract String getName();
}