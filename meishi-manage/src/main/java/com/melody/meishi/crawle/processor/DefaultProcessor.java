package com.melody.meishi.crawle.processor;

import com.meishi.common.util.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;
import us.codecraft.webmagic.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;

public class DefaultProcessor implements PageProcessor {

    private Site site;
    private String type;//类型 （家常菜、东北菜。。。）

    public DefaultProcessor(String startUrl, String type) {
        this.site = Site.me().setDomain(UrlUtils.getDomain(startUrl));
        this.type = type;
    }

    @Override
    public void process(Page page) {
        Selectable url = page.getUrl();

        if (url != null && !url.toString().endsWith(".html")) {
            if (!url.toString().contains(type)) {
                return;
            }
            addUrlToPage(page);
            return;
        }
    }

    /**
     * 不是以html结尾的页面，说明不是具体的菜谱页，则需要解析页面并添加相关的链接到page中
     * @param page
     */
    private void addUrlToPage(Page page) {
        List<Selectable> paginationSpans = page.getHtml().$("div.page_PN div.pagination span").nodes();
        int currentPosition = 0;//寻找到当前页面的编号
        for (int i = 0, l = paginationSpans.size(); i < l; i++) {
            Selectable spanNode = paginationSpans.get(i);
            String clazz = spanNode.xpath("//span/@class").toString();
            if (StringUtils.compareString(clazz, "current")) {
                currentPosition = i;
                break;
            }
        }
        //如果不是最后一个，后边一个内容不是下一页、尾页，则添加下个的链接到page中
        if (currentPosition < paginationSpans.size() - 1) {
            Selectable spanNode = paginationSpans.get(currentPosition + 1);
            String content = spanNode.xpath("//a/text()").toString();
            if (!StringUtils.compareString(content, "下一页") && !StringUtils.compareString(content, "尾页")) {
                String nextpage = spanNode.xpath("//a/@href").toString();
                page.addTargetRequest(nextpage);
            }
        }
        //解析具体的菜谱box，并将相关的菜谱的url放到page中进行下一步解析
        List<String> urls = new ArrayList<String>();
        List<Selectable> container = page.getHtml().$("dev.clearfix").nodes();
        if (container != null && !container.isEmpty()) {
            for (Selectable cpBox : container) {
                Selectable cpName = cpBox.$("div.cp_msg div.cp_name");
                String _url = cpName.xpath("//a/@href").toString();
                if (!StringUtils.isNullOrEmpty(_url) && _url.matches("http://www.douguo.com/cookbook/[0-9]{1,8}.html")) {
                    urls.add(_url);
                }
            }
        }
        page.addTargetRequests(urls);
    }

    @Override
    public Site getSite() {
        return site;
    }
}