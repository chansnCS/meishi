package com.melody.meishi.crawle.processor;
import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;
import us.codecraft.webmagic.utils.UrlUtils;

public class DouguoProcessor implements PageProcessor {
 
    private Site site;
    private String type;
	private String tableName;

    public DouguoProcessor(String startUrl, String urlPattern, String type, String tableName) {
        this.site = Site.me().setDomain(UrlUtils.getDomain(startUrl));
        this.type = type;
		this.tableName = tableName;

    }
 
    @Override
    public void process(Page page) {
 
    }
 
    @Override
    public Site getSite() {
        return site;
    }
}