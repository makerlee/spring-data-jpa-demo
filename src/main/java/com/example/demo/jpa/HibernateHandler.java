package com.example.demo.jpa;

import com.example.demo.domain.core.BaseEntity;
import com.example.demo.jpa.domain.hibernate.QueryParam;

import java.util.List;
import java.util.Map;

/**
 * Created by lijiyang on 2017/7/31.
 */
public interface HibernateHandler {

        public String addEntity(BaseEntity entity);

        public void modifyEntity(BaseEntity entity);

        public void removeEntity(BaseEntity entity);

        public <T> void removeEntityByProperty(Class<T> entityClass, String propertyName, Object propertyValue);

        public <T> void removeEntityByPropertys(Class<T> entityClass, Map<String, Object> param) ;

        public <T> void removeEntityByByQueryParam(Class<T> entityClass, List<QueryParam> queryParamList) ;

        public <T> T getEntityById(Class<T> entityClass, String id);

        public <T> List<T> getEntityListByProperty(Class<T> entityClass, String propertyName, Object propertyValue) ;

        public <T> List<T> getEntityListByProperty(Class<T> entityClass, String propertyName, Object propertyValue, Map<String, String> orderProps) ;

        public <T> List<T> getEntityListByProperty(Class<T> entityClass, String propertyName, Object propertyValue, int start, int count) ;

        public <T> List<T> getEntityListByProperty(Class<T> entityClass, String propertyName, Object propertyValue, int start, int count, Map<String, String> orderProps) ;

        public <T> int getEntityCountByProperty(Class<T> entityClass, String propertyName, Object propertyValue) ;

        public <T> List<T> getEntityListByPropertys(Class<T> entityClass, Map<String, Object> param, Map<String, String> orderProps) ;

        public <T> List<T> getEntityListByPropertys(Class<T> entityClass, Map<String, Object> param) ;

        public <T> int getEntityCountByPropertys(Class<T> entityClass, Map<String, Object> param) ;

        public <T> List<T> getEntityListByPropertys(Class<T> entityClass, Map<String, Object> param, int start, int count, Map<String, String> orderProps) ;

        public <T> List<T> getEntityListByPropertys(Class<T> entityClass, Map<String, Object> param, int start, int count) ;

        public <T> List<T> getEntityListAll(Class<T> entityClass, Map<String, String> orderProps) ;

        public <T> List<T> getEntityListAll(Class<T> entityClass) ;

        public <T> int getEntityCountAll(Class<T> entityClass);

        public <T> List<T> getEntityListAll(Class<T> entityClass, int start, int count, Map<String, String> orderProps) ;

        public <T> List<T> getEntityListAll(Class<T> entityClass, int start, int count) ;

        public <T> int getEntityCountByQueryParam(Class<T> entityClass, List<QueryParam> queryParamList) ;

        public <T> List<T> getEntityListByQueryParam(Class<T> entityClass, List<QueryParam> queryParamList, Map<String, String> orderProps) ;

        public <T> List<T> getEntityListByQueryParam(Class<T> entityClass, List<QueryParam> queryParamList) ;

        public <T> List<T> getEntityListByQueryParam(Class<T> entityClass, List<QueryParam> queryParamList, int start, int count, Map<String, String> orderProps) ;

        public <T> List<T> getEntityListByQueryParam(Class<T> entityClass, List<QueryParam> queryParamList, int start, int count) ;

    }
