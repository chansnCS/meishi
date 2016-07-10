package com.melody.meishi.crawle.controller;

import com.meishi.common.util.StringUtils;
import com.meishi.ws.service.MeishiService;
import com.melody.meishi.crawle.pipline.DefaultPipline;
import com.melody.meishi.crawle.processor.DefaultProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import us.codecraft.webmagic.Spider;

/**
 * Created by Cooper on 2015/8/31.
 */
@Controller
@RequestMapping(value = "/crawle")
public class CrawleController {

    private static final String PROPERTIES_FILE_NAME = "table.properties";

    @Autowired
    private DefaultPipline pipeline;

    @RequestMapping("/run")
    public void crawleChuancai(String table){

//        if (StringUtils.isNullOrEmpty(table)){
//            return;
//        }
//        String type = ReadProperties.getProperty(table,PROPERTIES_FILE_NAME);
//        if (StringUtil.isNullOrEmpty(type)){
//            return;
//        }
//

//        meishiService.batchSaveMeishi(new ArrayList<MeishiDTO>());

    }

    public static void main(String[] args) {
        DefaultPipline pipeline = new DefaultPipline();
        Spider.create(new DefaultProcessor("http://www.douguo.com/","家常菜"))
                .addUrl("http://www.douguo.com/caipu/家常菜/")
                .addPipeline(pipeline)
                .thread(30)//此处线程数可调节
                .run();
    }
}
