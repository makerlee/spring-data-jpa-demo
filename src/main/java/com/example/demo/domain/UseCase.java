package com.example.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by lijiyang on 2017/8/7.
 */
@Table(name = "sys_user_case")
@Entity
public class UseCase {
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 36, precision = 0)
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" ,strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "case_name", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    private String caseName;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
