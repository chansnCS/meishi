package com.melody.meishi.crawle.controller;

import com.meishi.ws.service.MeishiService;
import com.melody.meishi.crawle.pipline.DouguoPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Cooper on 2015/8/31.
 */
@Controller
@RequestMapping(value = "/crawle")
public class CrawleController {

    private static final String PROPERTIES_FILE_NAME = "table.properties";

    @Autowired
    private DouguoPipeline douguoPipeline;
    @Autowired
    private MeishiService meishiService;

    @RequestMapping("/run")
    public void crawleChuancai(String table){

//        if (StringUtil.isNullOrEmpty(table)){
//            return;
//        }
//        String type = ReadProperties.getProperty(table,PROPERTIES_FILE_NAME);
//        if (StringUtil.isNullOrEmpty(type)){
//            return;
//        }
//
//        DouguoProcessor processor = new DouguoProcessor("http://www.douguo.com/",null, type, table);
//
//        Spider.create(processor)
//                .addUrl("http://www.douguo.com/caipu/"+type+"/")
//                .addPipeline(douguoPipeline)
//                .thread(30)//此处线程数可调节
//                .run();
//        meishiService.batchSaveMeishi(new ArrayList<MeishiDTO>());

    }
}
