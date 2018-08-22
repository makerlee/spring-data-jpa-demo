package com.example.demo.webmagic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by lijiyang on 2018/8/22.
 */
@Component
public class ScheduleTest {
    @Autowired
    private Pipeline mysqlPipeline;

    @Scheduled(fixedDelay = 1000*60*60*24,initialDelay = 30000)
    public void test() {
        Spider.create(new LianJiaProcessor()).
                addUrl("https://zz.lianjia.com/ershoufang/pg1").
                addPipeline(mysqlPipeline).
                thread(5).
                run();
    }
}
