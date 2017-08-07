package com.example.demo.dao;

import com.example.demo.domain.User;
import org.jboss.jandex.Main;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;

/**
 * Created by lijiyang on 2017/7/31.
 */
@Repository
public class UserDao extends HibernateBaseDao<User> {
    private Class<User> entityClazz;

    public Class<User> getEntityClazz() {
        if (this.entityClazz == null) {
            this.entityClazz = (Class<User>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
            logger.debug("T class = " + this.entityClazz.getCanonicalName());
        }
        return this.entityClazz;
    }

//    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//        String can = userDao.getEntityClazz().getCanonicalName();
//        String name = userDao.getEntityClazz().getName();
//
//        System.out.println("--------->"+can);
//        System.out.println("_________>"+name);
//    }

}
