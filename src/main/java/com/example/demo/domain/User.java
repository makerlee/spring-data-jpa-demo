package com.example.demo.domain;

import com.example.demo.domain.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lijiyang on 2017/7/31.
 */
@Table(name = "sys_user")
@Entity
public class User extends BaseEntity{
    private String id;

    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 36, precision = 0)
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" ,strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String userName;

    @Column(name = "user_name", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String loginPwd;

    @Column(name = "login_pwd", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    private String loginState;

    @Column(name = "login_state", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
    @Basic
    public String getLoginState() {
        return loginState;
    }

    public void setLoginState(String loginState) {
        this.loginState = loginState;
    }
}
