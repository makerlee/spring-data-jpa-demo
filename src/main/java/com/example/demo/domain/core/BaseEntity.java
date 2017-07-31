package com.example.demo.domain.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by lijiyang on 2017/7/31.
 */
public abstract class BaseEntity implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(BaseEntity.class);

    /**
     * 产生实体json串
     */
    /**
    public String genEntityJsonStr(){
        JsonGenerater jsonGenerater=new JsonGeneratorImp();
        String json="{}";
        try {
            json=jsonGenerater.createJson(this,JsonGenerater.KEY_VALUE_STYLE_QUOT);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return json;
    }
    */

}
