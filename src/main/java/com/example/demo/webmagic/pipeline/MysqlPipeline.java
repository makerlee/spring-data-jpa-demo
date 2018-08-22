package com.example.demo.webmagic.pipeline;

import com.example.demo.domain.HouseInfo;
import com.example.demo.jpa.HibernateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by lijiyang on 2018/8/22.
 */
@Component
public class MysqlPipeline implements Pipeline {
    @Autowired
    private HibernateHandler hibernateHandler;

    @Override
    public void process(ResultItems resultItems, Task task) {
        if (null==resultItems){
            return;
        }
        if (resultItems.get("title")==null || "".equals(resultItems.get("title"))){
            return;
        }
        HouseInfo info = new HouseInfo();
        info.setTitile(resultItems.get("title"));
        info.setSubTitile(resultItems.get("subTitle"));
        if (org.apache.commons.lang3.StringUtils.isNumeric(resultItems.get("price"))){
            info.setPrice(Float.parseFloat(resultItems.get("price")));
        }
        if (org.apache.commons.lang3.StringUtils.isNumeric(resultItems.get("totalPrice"))){
            info.setTotalPrice(Float.parseFloat(resultItems.get("totalPrice")));
        }
        info.setArea(resultItems.get("area"));
        info.setHouseType(resultItems.get("houseType"));
        info.setLianjiaID(resultItems.get("lianjiaID"));
        info.setXiaoqu(resultItems.get("xiaoqu"));

        hibernateHandler.addEntity(info);
    }
}
