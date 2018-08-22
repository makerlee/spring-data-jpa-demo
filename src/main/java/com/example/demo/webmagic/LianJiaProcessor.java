package com.example.demo.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiyang on 2018/8/22.
 */
public class LianJiaProcessor implements PageProcessor{
    public static final String URL_LIST = "https://zz\\.lianjia\\.com/ershoufang/pg\\d+";
    public static final String URL_DETAIL = "https://zz\\.lianjia\\.com/ershoufang/\\d+\\.html";
    public static final List<String> ALL_LIST;

    static {
        ALL_LIST = new ArrayList<String>();
        for (int i=2;i<10;i++){
            ALL_LIST.add("https://zz.lianjia.com/ershoufang/pg"+i);
        }
    }

    private Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(500).setTimeOut(3 * 60 * 1000)
            .setDomain("zz.lianjia.com")
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .setCharset("UTF-8");


    @Override
    public void process(Page page) {
        if(page.getUrl().regex(URL_LIST).match()){
            System.out.println("--->list");
            page.addTargetRequests(ALL_LIST);
            page.addTargetRequests(page.getHtml().links().regex(URL_DETAIL).all());
        }else {
            System.out.println("--->detail");
            page.putField("title",page.getHtml().xpath("//div[@class='content']/div[@class='title']/h1/text()").toString());
            page.putField("subTitle",page.getHtml().xpath("//div[@class='content']/div[@class='title']/div/text()").toString());
            page.putField("price",page.getHtml().xpath("//div[@class='unitPrice']/span/text()").toString());
            page.putField("totalPrice",page.getHtml().xpath("//div[@class='price ']/span[@class='total']/text()").toString());
            page.putField("area",page.getHtml().xpath("//div[@class='areaName']/span[@class='info']/a[1]/text()").toString()+"|"+
                                 page.getHtml().xpath("//div[@class='areaName']/span[@class='info']/a[2]/text()").toString());
            page.putField("houseType",page.getHtml().xpath("//div[@class='houseInfo']/div[@class='room']/div[@class='mainInfo']/text()").toString()+"|"+
                                      page.getHtml().xpath("//div[@class='houseInfo']/div[@class='room']/div[@class='subInfo']/text()").toString());
            page.putField("xiaoqu",page.getHtml().xpath("//div[@class='aroundInfo']/div[@class='communityName']/a[1]/text()").toString());
            page.putField("lianjiaID",page.getHtml().xpath("//div[@class='houseRecord']/span[@class='info']/text()").toString());
        }
    }

    @Override
    public Site getSite() {
        return site;
    }


}
