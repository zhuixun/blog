package com.blog.bean.user;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-1-22
 * Time: 下午3:34
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User {
    /** 用户名 **/
    private String username;
    /** 密码 **/
    private String password;
    /** 真实姓名 **/
    private String realname;
    /** E-Mail **/
    private String email;
    /** 性别 **/
    private Gender gender=Gender.MAN;
    /** 是否启用 **/
    private Boolean visible=true;
    /** 注册时间 **/
    private Date regTime=new Date();

    @Id @Column(length=20)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Column(length = 32,nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Column(length = 45,nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(length = 10)
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
    @Enumerated(EnumType.STRING)@Column(length = 5,nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    @Column(nullable = false)
    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    @Temporal(TemporalType.TIMESTAMP) @Column(nullable = false)
    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}
